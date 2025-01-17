package com.eip.demo.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationRecord {


    @NotNull(message = "Field customerId cannot be null")
    @NotEmpty(message = "Field customerId cannot be empty")
    private String customerId;

    @NotNull(message = "Field customerId cannot be null")
    @NotEmpty(message = "Field customerId cannot be empty")
    private String gpsLocation;


}
