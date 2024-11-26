package org.chg.springsecurity_layered.user.presentation.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestApi {
    @GetMapping("/security/temp")
    public String securityTest() {
        return "Security Check";
    }
}
