package br.com.likwi.sso.subContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SSOSubContextApplication {

    public static void main(String[] args) {
        SpringApplication.run(SSOSubContextApplication.class, args);
    }

}