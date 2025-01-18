package com.eip.service;

import com.eip.model.Address;

public interface PartyRetrivalService {
    Address getPartyAddress(String partyId);
}
