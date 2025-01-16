package com.eip.demo.config;

import com.eip.demo.model.PurchaseOrder;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

//@MessagingGateway(name = "customRouterGateway", defaultRequestChannel = "genericRouterChannel")
@MessagingGateway(name = "customRouterGateway", defaultRequestChannel = "genericRouterfilterChannel")
public interface CustomRouterGateway {

    @Gateway
    void routeMessage(Message<PurchaseOrder> message);
}
