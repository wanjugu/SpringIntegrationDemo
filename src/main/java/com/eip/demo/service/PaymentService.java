package com.eip.demo.service;

import com.eip.demo.model.PurchaseOrder;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    void submitPurchaseOrder(PurchaseOrder purchaseOrder);
//    String submitPurchaseOrder2(PurchaseOrder purchaseOrder);

}
