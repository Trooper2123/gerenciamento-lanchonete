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

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping({"user/{id}"})
    public ResponseEntity<?> getPurchaseByUser(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseService.findPurchaseByUserId(id));
    }

    @GetMapping({"{id}"})
    public ResponseEntity<?> getPurchaseById(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseService.findPurchaseById(id));
    }
    @PutMapping({"{id}"})
    public ResponseEntity<?> updateStatus(@PathVariable Long id) {
        if(purchaseService.findPurchaseById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Status status = purchaseService.findPurchaseById(id).get().getStatus();
            switch (status) {
                case PROCESSING:
                    status = Status.PREPARING;
                    break;
                case PREPARING:
                    status = Status.DELIVERING;
                    break;
                    case DELIVERING:
                    status = Status.FINISHED;
                    break;
                default: status = Status.PROCESSING;}
            purchaseService.updatePurchase(id, status);
            return ResponseEntity.ok("Pedido Atualizado");
        }
    }

    @PutMapping({"cancel/{id}"})
    public ResponseEntity<?> cancel(@PathVariable Long id) {
        purchaseService.cancelPurchase(id);
        return ResponseEntity.ok("Pedido cancelado");
    }
}
