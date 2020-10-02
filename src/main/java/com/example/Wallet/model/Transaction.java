package com.example.Wallet.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @Column(name = "transactionId",nullable = false)
    //@GeneratedValue(strategy = GenerationType.)
    private String transactionId;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Column(name = "charge", nullable = false)
    private BigDecimal charge;
    @Column(name = "commision", nullable = false)
    private BigDecimal commision;
    @Column(name = "status", nullable = false)
    private String status;

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public Transaction(String transactionId, BigDecimal amount, BigDecimal charge, BigDecimal commision, String status, Wallet wallet, Date transactionDate, String transactionType) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.charge = charge;
        this.commision = commision;
        this.status = status;
        this.wallet = wallet;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }

    public BigDecimal getCommision() {
        return commision;
    }

    public void setCommision(BigDecimal commision) {
        this.commision = commision;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Transaction() {
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    private Date transactionDate;

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    private String transactionType;
}
