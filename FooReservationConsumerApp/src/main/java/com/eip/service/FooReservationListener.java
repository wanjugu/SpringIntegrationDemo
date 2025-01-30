package com.eip.service;


import com.eip.config.RabbitMQOutboundGatewayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FooReservationListener {

//    private final ServletRegistrationBean messageDispatcherServlet;
    private  RabbitMQOutboundGatewayConfig.AddressGateway addressGateway;

//    public FooReservationListener(ServletRegistrationBean messageDispatcherServlet, RabbitMQOutboundGatewayConfig.AddressGateway addressGateway) {
//        this.messageDispatcherServlet = messageDispatcherServlet;
//        this.addressGateway = addressGateway;
//    }

    @ServiceActivator(inputChannel = "fooReservationListenerChannel")
    public void handleMessage(Message message){
        log.info("Message: {}", message.getPayload());

        Message address = addressGateway.getAddress(1L);
        log.info("Address: {}", address.getPayload());
    }
}
