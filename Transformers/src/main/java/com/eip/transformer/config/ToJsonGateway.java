package com.eip.transformer.config;


import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name = "toJsonChannelGateway", defaultRequestChannel = "toJsonChannel")
public interface ToJsonGateway {

    @Gateway
    void toJson(Object reservation);
}
