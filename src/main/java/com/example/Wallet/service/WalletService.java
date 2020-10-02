package com.example.Wallet.service;

import com.example.Wallet.exception.WalletException;
import com.example.Wallet.request.AddMoney;
import com.example.Wallet.request.TransferMoney;
import com.example.Wallet.model.User;
import com.example.Wallet.model.Wallet;
import com.sun.istack.NotNull;
import net.minidev.json.JSONObject;

import java.util.List;

public interface WalletService {
    public Wallet createWallet(User user) throws WalletException;
    public JSONObject addMoney(AddMoney addMoney) throws WalletException;
    public Wallet updateWalletAmount(@NotNull Wallet wallet, String amount,@NotNull Boolean isCredit) throws WalletException;
    public JSONObject transferMoney(TransferMoney transferMoney) throws WalletException;
}
