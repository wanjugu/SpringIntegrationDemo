package com.eip.demo.model;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class GroupReservation {
    private String reservationId;
    private List<PartyReservation> parties = new ArrayList<>();

    public GroupReservation(String reservationId) {
    }
}
