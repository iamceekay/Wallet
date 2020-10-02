package com.example.Wallet.repository;

import com.example.Wallet.model.User;
import com.example.Wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Integer> {
    List<Wallet> findById(String id);
    @Query("SELECT u FROM Wallet u where u.id=?1")
    public List<Wallet> findWallet(String phoneNumber);
}
