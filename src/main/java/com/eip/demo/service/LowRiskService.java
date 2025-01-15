package com.eip.demo.service;

import com.eip.demo.model.SupportTicket;
import org.springframework.messaging.Message;

public interface LowRiskService {
    void handleSupportTicket(Message<SupportTicket> supportTicketMessage);
}
