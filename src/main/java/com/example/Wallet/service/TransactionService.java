package com.example.Wallet.service;

import com.example.Wallet.exception.WalletException;
import com.example.Wallet.model.Wallet;
import com.sun.istack.NotNull;
import net.minidev.json.JSONObject;

public interface TransactionService {
    public JSONObject getAllTransaction(@NotNull String phoneNumber) throws WalletException;
    public JSONObject reversalTransaction(String transactionId) throws WalletException;
    public JSONObject getTransactionStatus(String transactionId);
    public String createTransaction(Wallet wallet, String transactionType, String amount, String description) throws WalletException;
}
