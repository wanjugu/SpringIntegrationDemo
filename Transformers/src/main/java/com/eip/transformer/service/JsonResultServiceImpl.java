package com.eip.transformer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonResultServiceImpl implements  JsonResultService{

    @ServiceActivator(inputChannel = "jsonResultsChannel")
    @Override
    public void JsonResults(String results) {
        log.info("JSON Results: {} ", results);
    }
}
