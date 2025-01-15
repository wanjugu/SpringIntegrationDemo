package com.eip.demo.config;

import com.eip.demo.model.SupportTicket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

import java.util.logging.Logger;


@MessagingGateway(name = "headerRouterChannelGateway", defaultRequestChannel = "headerRouterChannel")
public interface HeaderRouterChannelGateway{


    @Gateway
    void routeMessage(Message<SupportTicket> message);
}
