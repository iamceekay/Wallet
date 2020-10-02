package com.example.Wallet.Utility;

public interface Authentication {
    public String encrypt(String password) throws Exception;
    public String decrypt(String password);
}
