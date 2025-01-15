package com.eip.demo.service;

import com.eip.demo.model.SupportTicket;
import org.springframework.messaging.Message;

public interface HighRiskService {
    void handleSupportTicket(Message<SupportTicket> supportTicketMessage);
}
