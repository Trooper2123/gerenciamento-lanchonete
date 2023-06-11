package com.trooper.gerenciamentoredelanchonetes.service;

import com.trooper.gerenciamentoredelanchonetes.model.Purchase;

public interface PurchaseServiceImpl {

    Purchase savePurchase(Purchase purchase);

    Purchase findPurchaseByUserName(String  userName);

    void updatePurchase(Long id);

    void deletePurchase(Long id);

}
