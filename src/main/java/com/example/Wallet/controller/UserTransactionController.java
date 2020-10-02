package com.example.Wallet.controller;

import com.example.Wallet.exception.WalletException;
import com.example.Wallet.service.TransactionService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserTransactionController {
    @Autowired
    private TransactionService transactionService;
    @GetMapping(path = "/viewPassbook/{phoneNumber}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject allTransaction(@PathVariable("phoneNumber") String phoneNumber) throws WalletException {

        return transactionService.getAllTransaction(phoneNumber);
    }
    @GetMapping(path = "/transactionStatus/{transactionId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject transactionStatus(@PathVariable("transactionId") String transactionId) throws WalletException {

        return transactionService.getTransactionStatus(transactionId);
    }
    @GetMapping(path = "/reversalTransaction/{transactionId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject reversalTransaction(@PathVariable("transactionId") String transactionId) throws WalletException {

        return transactionService.reversalTransaction(transactionId);
    }
}