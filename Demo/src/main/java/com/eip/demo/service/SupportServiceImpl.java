package com.eip.demo.service;

import com.eip.demo.config.HeaderRouterChannelGateway;
import com.eip.demo.config.RouterChannelGateway;
import com.eip.demo.model.SupportTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class SupportServiceImpl implements SupportService {

    @Autowired
    private HeaderRouterChannelGateway headerRouterChannelGateway;


    @Override
    public void openTicket(String customerId, String riskLevel, String description) {
        Message<SupportTicket> message = MessageBuilder.withPayload(new SupportTicket(customerId,description))
                .setHeader("riskLevel", riskLevel)
                .build();

        System.out.println("Risk Level------, "+ riskLevel);

        headerRouterChannelGateway.routeMessage(message);
    }
}
