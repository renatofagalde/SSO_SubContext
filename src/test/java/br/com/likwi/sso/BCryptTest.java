package br.com.likwi.sso;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class BCryptTest {

    public static void main(String[] args) {

        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("bCryptPasswordEncoder.encode(\"renato\") = " + bCryptPasswordEncoder.encode("renato"));
        System.out.println("bCryptPasswordEncoder.encode(\"senna\") = " + bCryptPasswordEncoder.encode("senna"));
    }
}
