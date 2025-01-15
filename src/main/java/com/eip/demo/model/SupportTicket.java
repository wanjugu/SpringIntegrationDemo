package com.eip.demo.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SupportTicket {

    @NotEmpty
    @NotNull
    @Size(min = 3, message = "Customer field must be more than two characters")
    private String customer;

    @NotNull
    @NotEmpty
    @Size(min = 3, message = "Description must be more than two characters")
    private String description;

    @NotNull
    @NotEmpty
    private String riskLevel = "low";

    public SupportTicket() {
    }

    public SupportTicket(String customer, String description, String riskLevel) {
        this.customer = customer;
        this.description = description;
        this.riskLevel = riskLevel;
    }

    public SupportTicket(String customer, String description) {
        this.customer = customer;
        this.description = description;
    }

    public @NotEmpty @NotNull @Size(min = 3, message = "Customer field must be more than two characters") String getCustomer() {
        return customer;
    }

    public void setCustomer(@NotEmpty @NotNull @Size(min = 3, message = "Customer field must be more than two characters") String customer) {
        this.customer = customer;
    }

    public @NotNull @NotEmpty String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(@NotNull @NotEmpty String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public @NotNull @NotEmpty @Size(min = 3, message = "Description must be more than two characters") String getDescription() {
        return description;
    }

    public void setDescription(@NotNull @NotEmpty @Size(min = 3, message = "Description must be more than two characters") String description) {
        this.description = description;
    }
}
