package br.com.marcotulio.wallet.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Bcrypt {

    public static String getHash(String password){
        return  password == null ? null : new BCryptPasswordEncoder().encode(password);
    }
}
