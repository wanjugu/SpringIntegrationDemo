package com.eip.transformer.config;


import com.eip.transformer.models.FamilyReservation;
import com.eip.transformer.models.PartyReservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.annotation.Transformers;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.validation.ObjectError;


@Slf4j
@Configuration
@EnableIntegration
public class TransformerConfig {

    @Bean
    public MessageChannel familyReservationChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel partyReservationChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel toJsonChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel jsonResultsChannel(){
        return  new DirectChannel();
    }


    @Bean
    public MessageChannel familyReservationJsonChannel(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "familyReservationJsonChannel", outputChannel = "familyReservationChannel")
    public JsonToObjectTransformer transform(){

        return new JsonToObjectTransformer(FamilyReservation.class);
    }



    @Transformer(inputChannel = "familyReservationChannel", outputChannel = "partyReservationChannel")
    public PartyReservation transform(FamilyReservation familyReservation){
        log.info("Transforming family Message with ID {} to a party reservation {}",
                familyReservation.getRoomType(),familyReservation.getName());

        return new PartyReservation(familyReservation.getFamilyId(),
                familyReservation.getRoomType(),
                familyReservation.getName());
    }

    @Bean
    @Transformer(inputChannel = "toJsonChannel", outputChannel = "jsonResultsChannel")
    public ObjectToJsonTransformer objectToJsonTransformer(){
        return new ObjectToJsonTransformer();
    }
}

