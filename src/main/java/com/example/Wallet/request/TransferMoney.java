package com.example.Wallet.request;

import java.math.BigDecimal;

public class TransferMoney {
    private String phoneNumberFrom;
    private BigDecimal amount;
    private String phoneNumberTO;

    public String getPhoneNumberFrom() {
        return phoneNumberFrom;
    }

    public void setPhoneNumberFrom(String phoneNumberFrom) {
        this.phoneNumberFrom = phoneNumberFrom;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPhoneNumberTO() {
        return phoneNumberTO;
    }

    public void setPhoneNumberTO(String phoneNumberTO) {
        this.phoneNumberTO = phoneNumberTO;
    }
}
