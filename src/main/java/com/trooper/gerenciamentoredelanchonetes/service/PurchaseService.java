package com.trooper.gerenciamentoredelanchonetes.service;

import com.trooper.gerenciamentoredelanchonetes.model.Purchase;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService implements PurchaseServiceImpl{


    @Override
    public Purchase savePurchase(Purchase purchase) {
        return null;
    }

    @Override
    public Purchase findPurchaseByUserName(String userName) {
        return null;
    }

    @Override
    public void updatePurchase(Long id) {

    }

    @Override
    public void deletePurchase(Long id) {

    }
}
