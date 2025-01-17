package com.eip.transformer.models;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FamilyReservation {
    private Integer familyId;
    private String name;
    private String roomType;
    private int numberOfChildren;
}
