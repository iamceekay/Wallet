package com.example.Wallet.repository;

import com.example.Wallet.model.Transaction;
import com.example.Wallet.model.User;
import com.example.Wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    @Query("SELECT t FROM Transaction t where t.transactionId=?1")
    public Transaction findTransactionDetail(String phoneNumber);
}
