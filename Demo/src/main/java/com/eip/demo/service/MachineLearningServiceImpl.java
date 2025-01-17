package com.eip.demo.service;

import com.eip.demo.model.LocationRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MachineLearningServiceImpl implements AuditService{

    @ServiceActivator(inputChannel = "machineLearningChannel")
    @Override
    public void handleLocationRecord(Message<LocationRecord> locationMessage) {
        LocationRecord locationRecord = locationMessage.getPayload();
        log.info("MachineLearning Service - Location record: CutomerID: {}, gpsLocation:{} ",
                locationRecord.getCustomerId(),locationRecord.getGpsLocation());
    }
}
