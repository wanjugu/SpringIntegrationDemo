package com.eip.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class AddressService {

    @ServiceActivator(inputChannel = "getAddressInputChannel")
    public String getAddress(Long id){
        log.info("Received a request for address for reservation {}", id);

        return "my address";
    }
}
