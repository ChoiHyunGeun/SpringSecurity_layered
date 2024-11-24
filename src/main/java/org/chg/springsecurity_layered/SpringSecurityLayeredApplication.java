package org.chg.springsecurity_layered;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityLayeredApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityLayeredApplication.class, args);
    }

}
