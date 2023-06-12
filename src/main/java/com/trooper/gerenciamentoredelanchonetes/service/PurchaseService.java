package com.trooper.gerenciamentoredelanchonetes.service;

import com.trooper.gerenciamentoredelanchonetes.model.Iten;
import com.trooper.gerenciamentoredelanchonetes.model.Purchase;
import com.trooper.gerenciamentoredelanchonetes.model.Status;
import com.trooper.gerenciamentoredelanchonetes.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PurchaseService implements PurchaseServiceImpl {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
   private ItenServiceImpl  itenService;

    @Override
    public Purchase savePurchase(Purchase purchase) {
        Optional<Iten> iten = itenService.findItenById(purchase.getItenId());
        if (iten.isEmpty()){
            throw new RuntimeException();
        }else {
            itenService.updateItenById(purchase.getItenId(),
                    iten.get().getQuantity() - purchase.getItenQuantity(), LocalDateTime.now());
            purchase.setPrice(iten.get().getPrice() * purchase.getItenQuantity());
            purchase.setPurchaseTime(LocalDateTime.now());
            purchase.setStatus(Status.PROCESSING);

            return purchaseRepository.save(purchase);
        }
    }

    @Override
    public Purchase findPurchaseByUserId(Long id) {
        return purchaseRepository.findByUserId(id);
    }

    @Override
    public Optional<Purchase> findPurchaseById(Long id) {
        return purchaseRepository.findById(id);
    }

    @Override
    @Transactional
    public void updatePurchase(Long id, Status status) {
        purchaseRepository.updateStatus(id, status, LocalDateTime.now());

    }

    @Transactional
    public void cancelPurchase(Long id) {
        purchaseRepository.updateStatus(id, Status.CANCELED,LocalDateTime.now());
    }
}
