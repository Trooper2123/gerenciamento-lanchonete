package com.trooper.gerenciamentoredelanchonetes.service;

import com.trooper.gerenciamentoredelanchonetes.model.Purchase;
import com.trooper.gerenciamentoredelanchonetes.model.Status;

import java.util.Optional;

public interface PurchaseServiceImpl {

    Purchase savePurchase(Purchase purchase);

    Purchase findPurchaseByUserId(Long userId);

    Optional<Purchase> findPurchaseById(Long id);

    void updatePurchase(Long id, Status status);

    void cancelPurchase(Long id);

}
