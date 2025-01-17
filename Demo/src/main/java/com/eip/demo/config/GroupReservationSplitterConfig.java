package com.eip.demo.config;

import com.eip.demo.model.GroupReservation;
import com.eip.demo.model.PartyReservation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableIntegration
public class GroupReservationSplitterConfig {

    @Bean
    public MessageChannel groupReservationChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel partyReservationChannel(){
        return new DirectChannel();
    }

//    @Splitter(inputChannel = "groupReservationChannel", outputChannel = "partyReservationChannel")
//    public List<Message<PartyReservation>> splitter(Message<GroupReservation> groupReservationMessage){
//
//        GroupReservation groupReservation = (GroupReservation) groupReservationMessage.getPayload();
//        return groupReservation.getParties().stream().map(
//                partyReservation-> MessageBuilder.withPayload(partyReservation).build()).collect(Collectors.toList());
//    }


    @Splitter(inputChannel = "groupReservationChannel", outputChannel = "partyReservationChannel")
    public List<PartyReservation> splitter(GroupReservation reservation){
        return reservation.getParties();
    }
}
