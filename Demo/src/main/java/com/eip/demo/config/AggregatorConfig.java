package com.eip.demo.config;

import com.eip.demo.model.GroupReservation;
import com.eip.demo.model.PartyReservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@EnableIntegration
public class AggregatorConfig {

    @Bean public MessageChannel aggregatorGroupReservationChannel() {
        return new DirectChannel();
    }
    @Bean public MessageChannel aggregatorPartyReservationChannel() {
        return new DirectChannel();
    }
    @Bean public MessageChannel reservationAggregatorChannel() {
        return new DirectChannel();
    }
    @Bean public MessageChannel reservationCompletedChannel() {
        return new DirectChannel();
    }

    @Splitter(inputChannel = "aggregatorGroupReservationChannel", outputChannel = "aggregatorPartyReservationChannel")
    public List<Message<PartyReservation>> splitter(GroupReservation groupReservation) {
        log.info("Splitting group: {}", groupReservation.getReservationId());
        return groupReservation.getParties().stream()
                .map(partyReservation -> MessageBuilder.withPayload(partyReservation)
                        .setHeader("RESERVATION_ID", groupReservation.getReservationId())
                        .build()).collect(Collectors.toList());
    }
    @Aggregator(inputChannel = "reservationAggregatorChannel", outputChannel = "reservationCompletedChannel")
    public GroupReservation aggregator(List<Message<PartyReservation>> partyReservations) {
        GroupReservation groupReservation = new GroupReservation(
                (String) partyReservations.get(0).getHeaders().get("RESERVATION_ID"));
        groupReservation.getParties().addAll(partyReservations.stream()
                .map(Message::getPayload)
                .collect(Collectors.toList()));
        log.info("Aggregating group: {} - {} parties",
                groupReservation.getReservationId(), groupReservation.getParties().size());
        return groupReservation;
    }
}
