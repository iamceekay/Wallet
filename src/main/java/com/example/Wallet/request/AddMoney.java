package com.example.Wallet.request;

import java.math.BigDecimal;

public class AddMoney {
    private BigDecimal amount;
    private String phoneNumber;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
