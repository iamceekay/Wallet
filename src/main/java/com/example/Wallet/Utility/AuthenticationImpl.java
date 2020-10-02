package com.example.Wallet.Utility;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationImpl implements Authentication {
    @Override
    public String encrypt(String valueToEnc) throws Exception {
        byte[] bytesEncoded = Base64.encodeBase64(valueToEnc.getBytes());
        return new String(bytesEncoded);
    }

    @Override
    public String decrypt(String valueToDec) {
        byte[] valueDecoded = Base64.decodeBase64(valueToDec.getBytes());
        return new String(valueDecoded);
    }

}
