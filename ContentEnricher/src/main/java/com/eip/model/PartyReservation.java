package com.eip.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartyReservation {

    private Integer partyId;
    private String roomType;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;

    public PartyReservation(Integer partyId, String roomType, String name) {
       this.partyId = partyId;
       this.roomType = roomType;
       this.name = name;
    }
}
