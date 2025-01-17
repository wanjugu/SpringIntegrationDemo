package com.eip.demo.service;

import com.eip.demo.model.PurchaseOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class LowCostPurchaseServiceImpl implements LowCostPurchaseService{

    private static final Logger log = LoggerFactory.getLogger(LowCostPurchaseServiceImpl.class);

//    @ServiceActivator(inputChannel = "standardPaymentChannel")
    @Override
    public void handlePayment(Message<PurchaseOrder> purchaseOrderMessage) {
        PurchaseOrder purchaseOrder = purchaseOrderMessage.getPayload();
        log.info("Low Cost Purchase Order: Customer: {}, Amount: {}", purchaseOrder.getCustomerId(),purchaseOrder.getAmount());

    }


    @ServiceActivator(inputChannel = "standardPaymentChannel")
    @Override
    public ResponseEntity<?> handlePayment2(Message<PurchaseOrder> purchaseOrderMessage) {
      PurchaseOrder purchaseOrder = purchaseOrderMessage.getPayload();

        System.out.println(purchaseOrder.getAmount());

        log.info("Purchase Order Recorded Successfully");

        return new ResponseEntity<>("PartySome", HttpStatus.OK);
    }
}
