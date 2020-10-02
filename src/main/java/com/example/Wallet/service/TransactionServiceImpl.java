package com.example.Wallet.service;

import com.example.Wallet.Utility.JsonFormatter;
import com.example.Wallet.exception.WalletException;
import com.example.Wallet.model.Transaction;
import com.example.Wallet.model.User;
import com.example.Wallet.model.Wallet;
import com.example.Wallet.repository.TransactionRepository;
import com.example.Wallet.repository.UserRepository;
import com.example.Wallet.repository.WalletRepository;
import com.example.Wallet.request.TransactionStatus;
import com.example.Wallet.request.TransactionType;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private WalletService walletService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private JsonFormatter jsonFormatter;
    @Override
    public JSONObject getAllTransaction(String phoneNumber) throws WalletException {
        List<User> detail =userRepository.findPhoneNumber(phoneNumber);
        List<Transaction> allTransaction=new ArrayList<>();
        if(detail.size()>0)
        allTransaction = detail.get(0).getWallets().get(0).getTransaction();
        return jsonFormatter.JsonFormatTransaction(allTransaction);
    }

    @Override
    public JSONObject reversalTransaction(String transactionId) throws WalletException {
        Transaction transaction = transactionRepository.findTransactionDetail(transactionId);
        String updatedTransactionId=null;
        if(transaction.getStatus().equals(TransactionStatus.failure.toString()))
        {

            updatedTransactionId=transactionService.createTransaction(transaction.getWallet(), TransactionType.Credit.toString(),transaction.getAmount().toString(),"Reversal Money");
        }
        if(updatedTransactionId!=null)
            return jsonFormatter.JsonFormatTransaction(transactionRepository.findTransactionDetail(updatedTransactionId));
        return jsonFormatter.JsonFormatStatus(transactionId,"No Reversal Required");
    }

    @Override
    public JSONObject getTransactionStatus(String transactionId) {
        Transaction transaction = transactionRepository.findTransactionDetail(transactionId);
        return JsonFormatter.JsonFormatTransaction(transaction);
    }

    @Override
    public String createTransaction(Wallet wallet, String transactionType, String amount, String description) throws WalletException {
        boolean iscredit=transactionType==TransactionType.Credit.toString();
        double charge=0.02*Double.valueOf(amount);
        double commision=0.005*Double.valueOf(amount);
        BigDecimal finalAmount=new BigDecimal(amount).subtract(new BigDecimal(charge));
        UUID uuid = UUID.randomUUID();
        if(wallet!=null)
        {
            wallet=walletService.updateWalletAmount(wallet,String.valueOf(finalAmount),iscredit);
            Transaction transaction=new Transaction(uuid.toString(),
                    finalAmount,
                    new BigDecimal(charge),new BigDecimal(commision), TransactionStatus.Success.toString(),wallet,
                    new Date(),transactionType
                    );
            transactionRepository.save(transaction);
        }
        return uuid.toString();
    }
}
