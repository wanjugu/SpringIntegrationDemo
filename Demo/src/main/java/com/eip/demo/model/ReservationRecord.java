package com.eip.demo.model;


import lombok.*;


//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ReservationRecord {
    private String id;
    private String name;


    public ReservationRecord(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
