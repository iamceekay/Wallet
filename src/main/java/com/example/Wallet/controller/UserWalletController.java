package com.example.Wallet.controller;

import com.example.Wallet.exception.WalletException;
import com.example.Wallet.model.*;
import com.example.Wallet.request.AddMoney;
import com.example.Wallet.request.TransferMoney;
import com.example.Wallet.service.WalletService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserWalletController {

    @Autowired
    private WalletService walletService;
    @PostMapping(path = "/addMoney",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject addMoneyToWallet(@RequestBody AddMoney addMoney) throws WalletException {

        return  walletService.addMoney(addMoney);
    }
    @PostMapping(path = "/transferMoney",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject transferMoney(@RequestBody TransferMoney transferMoney) throws WalletException {

        return walletService.transferMoney(transferMoney);

    }
}
