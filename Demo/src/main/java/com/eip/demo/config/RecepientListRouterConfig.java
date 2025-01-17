package com.eip.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.router.RecipientListRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableIntegration
public class RecepientListRouterConfig {

    @Bean
    public MessageChannel recipientListRouterChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel recipientAuditRouterChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel machineLearningChannel(){
        return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "recipientListRouterChannel")
    @Bean
    public RecipientListRouter recipientListRouter(){

        RecipientListRouter router = new RecipientListRouter();
        router.addRecipient("recipientAuditRouterChannel");
        router.addRecipient("machineLearningChannel");
        return router;
    }

}
