package org.chg.springsecurity_layered.user.presentation.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginSuccessApi {
    @GetMapping("/")
    public String root(){
        return "SUCCESS";
    }
}
