package com.example.Wallet.service;

import com.example.Wallet.Utility.Authentication;
import com.example.Wallet.Utility.JsonFormatter;
import com.example.Wallet.request.LoginUser;
import com.example.Wallet.request.TransactionStatus;
import com.example.Wallet.model.User;
import com.example.Wallet.repository.UserRepository;
import com.example.Wallet.repository.WalletRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletService walletService;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private Authentication authentication;
    @Autowired
    private JsonFormatter jsonFormatter;

    @Override
    public JSONObject registration(User registration) throws Exception {
        List<User> detail = userRepository.findPhoneNumber(registration.getPhoneNumber());
        String status=null;
        if (detail.size()>0)
            status=TransactionStatus.failure.toString();
        else {
            User user = new User(registration.getFirstName(), registration.getLastName(), registration.getPhoneNumber(), registration.getEmailid(), authentication.encrypt(registration.getPassword()));
            userRepository.save(user);
            walletService.createWallet(user);

            status= TransactionStatus.Success.toString();
        }
        return jsonFormatter.JsonFormatUser(registration.getPhoneNumber(),status,status=="Success"?"Registration Successfull":"Account does Exist");

    }

    @Override
    public JSONObject loginUser(LoginUser loginUser) {
        List<User> detail =userRepository.findPhoneNumber(loginUser.getPhoneNumber());
        if(detail.size()>0)
        {
            if(loginUser.getPassword().equals(authentication.decrypt(detail.get(0).getPassword()))) {
              return  jsonFormatter.JsonFormatUser(loginUser,detail.get(0).getWallets().get(0).getBalance(),"Login Successfully");

            }
            else
               return jsonFormatter.JsonFormatUser(loginUser,"Invalid Credential");
        }
        return jsonFormatter.JsonFormatUser(loginUser,"Registration Required");
       // return jsonFormatter.JsonFormatUser(loginUser.getPhoneNumber(),status,status=="Success"?"Registration Successfull":"Account does Exist");
    }
}
