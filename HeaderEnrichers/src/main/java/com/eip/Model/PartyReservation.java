package com.eip.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartyReservation {

    private Integer partyId;
    private String roomType;
    private String name;
    private String confirmationNumber;
}
