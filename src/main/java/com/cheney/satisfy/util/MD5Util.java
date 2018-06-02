package com.cheney.satisfy.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String digest(String password) {
        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (!StringUtil.isNullOrBlank(password)) {
            byte[] digest = md5.digest(password.getBytes());
            password = new BigInteger(1, digest).toString(16);
        }

        return password;
    }
}
