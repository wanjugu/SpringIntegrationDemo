package com.eip.demo.service;


import com.eip.demo.model.LocationRecord;
import org.springframework.messaging.Message;

public interface AuditService {
    void handleLocationRecord(Message<LocationRecord> locationMessage);
}
