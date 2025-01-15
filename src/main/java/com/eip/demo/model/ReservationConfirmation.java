package com.eip.demo.model;


import lombok.*;


//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ReservationConfirmation {
    private String reservationId;
    private String confirmationNumber;

    public ReservationConfirmation(String reservationId, String confirmationNumber) {
        this.reservationId = reservationId;
        this.confirmationNumber = confirmationNumber;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

}
