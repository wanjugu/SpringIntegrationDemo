package com.eip.demo.config;


import com.eip.demo.model.SupportTicket;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name="routerChannelGateway", defaultRequestChannel = "routerChannel")
public interface RouterChannelGateway {
    @Gateway
    Message<String> routeMessage(Message message);
}


