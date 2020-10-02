package com.example.Wallet.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="wallet")
public class Wallet {
    @Id
    @Column(name = "wallet_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "balance",nullable = false)
    private BigDecimal balance;

    public Wallet() {
    }

    public Wallet(BigDecimal balance, User user) {
        this.balance = balance;
        this.user = user;
    }

    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;
    @OneToMany(mappedBy = "wallet")
    private List<Transaction> transaction;

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }



}
