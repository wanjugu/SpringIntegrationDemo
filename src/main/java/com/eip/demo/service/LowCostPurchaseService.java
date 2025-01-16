package com.eip.demo.service;

import com.eip.demo.model.PurchaseOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;

public interface LowCostPurchaseService {
    void handlePayment(Message<PurchaseOrder> purchaseOrderMessage);

    ResponseEntity<?> handlePayment2(Message<PurchaseOrder> purchaseOrderMessage);
}
