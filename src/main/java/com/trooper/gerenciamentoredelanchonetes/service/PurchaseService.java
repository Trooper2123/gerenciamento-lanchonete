package com.trooper.gerenciamentoredelanchonetes.service;

import com.trooper.gerenciamentoredelanchonetes.model.Iten;
import com.trooper.gerenciamentoredelanchonetes.model.Purchase;
import com.trooper.gerenciamentoredelanchonetes.model.Status;
import com.trooper.gerenciamentoredelanchonetes.repository.ItenRepository;
import com.trooper.gerenciamentoredelanchonetes.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class PurchaseService implements PurchaseServiceImpl {

    @Autowired
    private PurchaseRepository purchaseRepository;
    private ItenRepository itenRepository;

    private Logger logger;

    @Override
    public Purchase savePurchase(Purchase purchase) {
        ArrayList<Iten> itensIds = purchase.getItensId();
        ArrayList<Iten> itensFinal = new ArrayList<>();
        for (Iten itensId : itensIds) {
            if (itenRepository.findById(itensId.getId()).isPresent()) {
                itensFinal.add(itensId);
            } else {
                logger.info("O iten: '{}',  não consta no estoque da loja", itensId.getName());
            }
        }
        purchase.setItensId(itensFinal);
        purchase.setPurchaseTime(LocalDateTime.now());
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase findPurchaseByUserId(Long id) {
        return purchaseRepository.findByUserId(id);
    }

    @Override
    public void updatePurchase(Long id, Status status) {
        purchaseRepository.updateStatus(id, status);

    }

    public void cancelPurchase(Long id) {
        purchaseRepository.updateStatus(id, Status.CANCELED);
    }
}
