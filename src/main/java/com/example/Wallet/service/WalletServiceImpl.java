package com.example.Wallet.service;

import com.example.Wallet.Utility.JsonFormatter;
import com.example.Wallet.exception.WalletException;
import com.example.Wallet.model.*;
import com.example.Wallet.repository.UserRepository;
import com.example.Wallet.repository.WalletRepository;
import com.example.Wallet.request.AddMoney;
import com.example.Wallet.request.TransactionStatus;
import com.example.Wallet.request.TransactionType;
import com.example.Wallet.request.TransferMoney;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService{
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private JsonFormatter jsonFormatter;
    @Override
    public Wallet createWallet(User user) throws WalletException {
        return walletRepository.save(new Wallet(new BigDecimal(0),user));
    }

    @Override
    public JSONObject addMoney(AddMoney addMoney) throws WalletException {
        List<User> detail = userRepository.findPhoneNumber(addMoney.getPhoneNumber());
        String transactionId=null;
        if(detail.size()>0)
        {
            transactionId=transactionService.createTransaction(detail.get(0).getWallets().get(0), TransactionType.Credit.toString(),addMoney.getAmount().toString(),"adding Money");

            }
        return jsonFormatter.JsonFormataddMoney(transactionId,addMoney.getPhoneNumber(),addMoney.getAmount(),transactionId==null?"Unsuccessfull in adding money":"Money has been added successfully");
        }

    @Override
    public Wallet updateWalletAmount(Wallet wallet, String amount, Boolean isCredit) throws WalletException {
        BigDecimal transactionAmount = (isCredit) ? new BigDecimal(amount).abs() : new BigDecimal(amount).abs().negate();
        Boolean condition = (isCredit || (wallet.getBalance().compareTo(transactionAmount.abs()) >= 0) );
        wallet.setBalance(wallet.getBalance().add(transactionAmount));
        wallet.setLastUpdated(new Date());
        return walletRepository.save(wallet);

    }

    @Override
    public JSONObject transferMoney(TransferMoney transferMoney) throws WalletException {
        List<User> detailFrom = userRepository.findPhoneNumber(transferMoney.getPhoneNumberFrom());
        String transactionId=null;
        if(detailFrom.size()>0)
        {
            List<User> detailTo = userRepository.findPhoneNumber(transferMoney.getPhoneNumberTO());
            if(detailTo.size()>0 && (detailFrom.get(0).getWallets().get(0).getBalance().compareTo(transferMoney.getAmount().abs()) >= 0))
            {
                transactionId=transactionService.createTransaction(detailFrom.get(0).getWallets().get(0),TransactionType.Debit.toString(),transferMoney.getAmount().toString(),"debit Money");
                transactionService.createTransaction(detailTo.get(0).getWallets().get(0),TransactionType.Credit.toString(),transferMoney.getAmount().toString(),"credit Money");
            }
        }
       return jsonFormatter.JsonFormatTransfer(transferMoney.getAmount().toString(),transferMoney.getPhoneNumberFrom(), transferMoney.getPhoneNumberTO(), transactionId,transactionId==null? TransactionStatus.failure.toString():TransactionStatus.Success.toString());
    }
}
