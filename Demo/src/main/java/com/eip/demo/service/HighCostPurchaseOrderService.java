package com.eip.demo.service;

import com.eip.demo.model.PurchaseOrder;
import org.springframework.messaging.Message;

public interface HighCostPurchaseOrderService {
    void handlePayment(Message<PurchaseOrder> purchaseOrderMessage);
}
