package com.eip.demo.service;


import com.eip.demo.config.CustomRouterGateway;
import com.eip.demo.model.PurchaseOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private CustomRouterGateway customRouterGateway;

    @Override
    public void submitPurchaseOrder(PurchaseOrder purchaseOrder) {
        log.info("Submitting purchase order for customer {} with amount {}",
                purchaseOrder.getCustomerId(),purchaseOrder.getAmount());
        customRouterGateway.routeMessage(MessageBuilder.withPayload(purchaseOrder).build());
    }

//    @Override
//    public String submitPurchaseOrder2(PurchaseOrder purchaseOrder) {
//        log.info("Submitting purchase order for customer {} with amount {}",
//                purchaseOrder.getCustomerId(),purchaseOrder.getAmount());
//
//        customRouterGateway.routeMessage(MessageBuilder.withPayload(purchaseOrder).build());
//
////        Message<String> response = customRouterGateway.routeMessage(MessageBuilder.withPayload(purchaseOrder).build());
//
////        return response.getPayload();
//
//    }
}
