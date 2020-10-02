package com.example.Wallet.Utility;

import com.example.Wallet.request.*;
import com.example.Wallet.model.Transaction;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class JsonFormatter {
   public static JSONObject JsonFormatTransaction(List<Transaction> transaction)
    {
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(Transaction eachTransaction:transaction)
        {
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("Transactionid",eachTransaction.getTransactionId());
            formDetailsJson.put("Amount",eachTransaction.getAmount());
            formDetailsJson.put("Status",eachTransaction.getStatus());
            formDetailsJson.put("TransactionDate",eachTransaction.getTransactionDate());
            formDetailsJson.put("Charge",eachTransaction.getCharge());
            formDetailsJson.put("Commision",eachTransaction.getCommision());
            formDetailsJson.put("TransactionType",eachTransaction.getTransactionType());
            jsonArray.add(formDetailsJson);
        }
        responseDetailsJson.put("Transaction", jsonArray);
        return responseDetailsJson;
    }
    public static JSONObject JsonFormatTransfer(String amount,String from, String to, String transactionId,String status)
    {
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
            JSONObject formDetailsJson = new JSONObject();
            formDetailsJson.put("Transactionid",transactionId);
            formDetailsJson.put("Amount",amount);
            formDetailsJson.put("From",from);
            formDetailsJson.put("To",to);
            formDetailsJson.put("Status",status);
            jsonArray.add(formDetailsJson);
        responseDetailsJson.put("Transaction", jsonArray);
        return responseDetailsJson;
    }
    public static JSONObject JsonFormatTransaction(Transaction transaction)
    {
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject formDetailsJson = new JSONObject();
        formDetailsJson.put("Transaction id",transaction.getTransactionId());
        formDetailsJson.put("Status",transaction.getStatus());
        formDetailsJson.put("Amount",transaction.getAmount());
        formDetailsJson.put("Transaction Type",transaction.getTransactionType());
        formDetailsJson.put("Transaction Date",transaction.getTransactionDate());
        jsonArray.add(formDetailsJson);
        responseDetailsJson.put("Transaction", jsonArray);
        return responseDetailsJson;
    }
    public static JSONObject JsonFormatUser(String phoneNumber,String status,String statusMessage)
    {
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject formDetailsJson = new JSONObject();
        formDetailsJson.put("PhoneNumber",phoneNumber);
        formDetailsJson.put("Status",status);
        formDetailsJson.put("Status Message",statusMessage);
        jsonArray.add(formDetailsJson);
        responseDetailsJson.put("Registration Info", jsonArray);
        return responseDetailsJson;
    }

    public static  JSONObject JsonFormatUser(LoginUser loginUser, String statusMessage)  {
        statusMessage=statusMessage=="Registration Required"?statusMessage:"Invalid credential, Kindly provide Correct password";
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject formDetailsJson = new JSONObject();
        formDetailsJson.put("PhoneNumber",loginUser.getPhoneNumber());
        formDetailsJson.put("Password",loginUser.getPassword());
        formDetailsJson.put("Status Message",statusMessage);
        jsonArray.add(formDetailsJson);
        responseDetailsJson.put("Registration Info", jsonArray);
        return responseDetailsJson;
    }
    public static JSONObject JsonFormatUser(LoginUser loginUser, BigDecimal Balance, String statusMessage)
    {
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject formDetailsJson = new JSONObject();
        formDetailsJson.put("PhoneNumber",loginUser.getPhoneNumber());
        formDetailsJson.put("Status","Successfully Login");
        formDetailsJson.put("Balance Amount",Balance);
        jsonArray.add(formDetailsJson);
        responseDetailsJson.put("User Info", jsonArray);
        return responseDetailsJson;
    }

    public JSONObject JsonFormataddMoney(String transactionId, String phoneNumber, BigDecimal amount, String status) {
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject formDetailsJson = new JSONObject();
        formDetailsJson.put("transactionId",transactionId);
        formDetailsJson.put("Status",status);
        formDetailsJson.put("Amount",amount);
        formDetailsJson.put("phoneNumber ",phoneNumber);
        jsonArray.add(formDetailsJson);
        responseDetailsJson.put("Money Add", jsonArray);
        return responseDetailsJson;
    }

    public JSONObject JsonFormatStatus(String transactionId, String no_reversal_required) {
        JSONObject responseDetailsJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject formDetailsJson = new JSONObject();
        formDetailsJson.put("transactionId",transactionId);
        formDetailsJson.put("Status",no_reversal_required);
        jsonArray.add(formDetailsJson);
        responseDetailsJson.put("Transaction Info", jsonArray);
        return responseDetailsJson;
    }
}
