package com.eip.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.outbound.AmqpOutboundEndpoint;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@Configuration
public class RabbitMQOutboundGatewayConfig {

    static  final String ADDRESS_QUEUE = "get-address";

    @Bean
    public MessageChannel fooAddressChannel(){
        return  new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "fooAddressChannel")
    public AmqpOutboundEndpoint amqpOutboundEndpoint(AmqpTemplate amqpTemplate){

        AmqpOutboundEndpoint outboundEndpoint = new AmqpOutboundEndpoint(amqpTemplate);
        outboundEndpoint.setExpectReply(true);
        outboundEndpoint.setRoutingKey(ADDRESS_QUEUE);
        return outboundEndpoint;

    }

    @MessagingGateway(defaultRequestChannel = "fooAddressChannel")
    public interface  AddressGateway{
        Message getAddress(Long userId);
    }
}
