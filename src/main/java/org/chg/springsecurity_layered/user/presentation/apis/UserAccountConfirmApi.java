package org.chg.springsecurity_layered.user.presentation.apis;

import org.chg.springsecurity_layered.user.application.UserFacade;
import org.chg.springsecurity_layered.user.domain.User;
import org.chg.springsecurity_layered.user.presentation.UserRequest;
import org.chg.springsecurity_layered.user.presentation.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/user")
@Controller
public final class UserAccountConfirmApi {
    private final UserFacade userFacade;


    public UserAccountConfirmApi( UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @ResponseBody
    @GetMapping("/userInfo")
    public ResponseEntity<UserResponse> findUserInfo(@RequestBody UserRequest userRequest) {
        Optional<User> user = userFacade.findById(userRequest.getSeq());

        return new ResponseEntity<>(user.orElseThrow().toDto(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@RequestBody UserRequest userRequest) {
        userFacade.save(userRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<UserResponse> userDelete(@RequestBody UserRequest userRequest) {
        userFacade.delete(userRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<UserResponse> userUpdate(@RequestBody UserRequest userRequest) {
        userFacade.update(userRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
