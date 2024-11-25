package org.chg.springsecurity_layered.user.presentation;

import org.chg.springsecurity_layered.user.application.UserFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Controller
public final class UserAccountConfirmApi {
    Logger logger = LoggerFactory.getLogger(UserAccountConfirmApi.class);

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    public UserAccountConfirmApi(
            UserFacade userFacade,
            PasswordEncoder passwordEncoder
    ) {
        this.userFacade = userFacade;
        this.passwordEncoder = passwordEncoder;
    }

    @ResponseBody
    @PostMapping("/userInfo")
    public ResponseEntity<?> findUserInfo(@RequestBody UserRequest userRequest) {

        userFacade.findById(userRequest.userId);
        
        logger.debug("들어옴");
        
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register")
    public void userRegister(@RequestBody UserRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.password));
        logger.debug("저장됨.");
        userFacade.save(userRequest);
    }
}
