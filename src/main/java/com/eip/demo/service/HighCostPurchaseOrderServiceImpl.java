package com.eip.demo.service;

import com.eip.demo.model.PurchaseOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HighCostPurchaseOrderServiceImpl implements HighCostPurchaseOrderService{

    @ServiceActivator(inputChannel = "highCostPaymentChannel")
    @Override
    public void handlePayment(Message<PurchaseOrder> purchaseOrderMessage) {
        PurchaseOrder purchaseOrder = (PurchaseOrder) purchaseOrderMessage.getPayload();
      log.info("High Cost Purchase Order: Customer: {}, Amount: {}",
              purchaseOrder.getCustomerId(), purchaseOrder.getAmount());
    }
}
