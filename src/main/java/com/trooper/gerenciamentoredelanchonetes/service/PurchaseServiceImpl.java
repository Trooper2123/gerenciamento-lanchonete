package com.trooper.gerenciamentoredelanchonetes.service;

import com.trooper.gerenciamentoredelanchonetes.model.Purchase;
import com.trooper.gerenciamentoredelanchonetes.model.Status;

public interface PurchaseServiceImpl {

    Purchase savePurchase(Purchase purchase);

    Purchase findPurchaseByUserId(Long userId);

    void updatePurchase(Long id, Status status);

    void cancelPurchase(Long id);

}
