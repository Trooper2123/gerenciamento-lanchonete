package com.trooper.gerenciamentoredelanchonetes.controller;

import com.trooper.gerenciamentoredelanchonetes.model.Purchase;
import com.trooper.gerenciamentoredelanchonetes.model.Status;
import com.trooper.gerenciamentoredelanchonetes.service.PurchaseServiceImpl;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseServiceImpl purchaseService;

    @PostMapping //api/purchase-history
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<?> getPurchaseByUser(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseService.findPurchaseByUserId(id));
    }

    @PutMapping({"{id}"})
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Status status) {
        purchaseService.updatePurchase(id, status);
        return ResponseEntity.ok("Pedido Atualizado");
    }

    @PutMapping({"cancel/{id}"})
    public ResponseEntity<?> update(@PathVariable Long id) {
        purchaseService.cancelPurchase(id);
        return ResponseEntity.ok("Pedido cancelado");
    }
}
