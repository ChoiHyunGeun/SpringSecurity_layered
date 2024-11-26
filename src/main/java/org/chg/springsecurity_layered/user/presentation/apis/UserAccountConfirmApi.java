package org.chg.springsecurity_layered.user.presentation.apis;

import org.chg.springsecurity_layered.user.application.facade.UserManager;
import org.chg.springsecurity_layered.user.domain.User;
import org.chg.springsecurity_layered.user.domain.exception.UserNotFoundException;
import org.chg.springsecurity_layered.user.presentation.UserRegisterRequest;
import org.chg.springsecurity_layered.user.presentation.UserResponse;
import org.chg.springsecurity_layered.user.presentation.UserUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/user")
@Controller
public final class UserAccountConfirmApi {
    private final UserManager userManager;


    public UserAccountConfirmApi( UserManager userManager) {
        this.userManager = userManager;
    }

    @ResponseBody
    @GetMapping("/userInfo")
    public ResponseEntity<UserResponse> findUserInfo(@RequestBody UserRegisterRequest userRegisterRequest) {
        Optional<User> user = userManager.findById(userRegisterRequest.getSeq());

        return new ResponseEntity<>(user.orElseThrow(UserNotFoundException::new).toDto(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        userManager.save(userRegisterRequest.toCommand(userRegisterRequest));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<UserResponse> userDelete(@RequestBody UserRegisterRequest userRegisterRequest) {
        userManager.delete(userRegisterRequest.getSeq());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<UserResponse> userUpdate(@RequestBody UserUpdateRequest userUpdateRequest) {
        userManager.update(userUpdateRequest.toCommand(userUpdateRequest));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
