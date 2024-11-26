package org.chg.springsecurity_layered.user.presentation.apis;

import org.chg.springsecurity_layered.common.command.ResponseCommand;
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

import java.time.LocalDateTime;
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
    public ResponseEntity<ResponseCommand> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        userManager.save(userRegisterRequest.toCommand(userRegisterRequest));
        return new ResponseEntity<>(
                ResponseCommand.builder()
                        .code(200)
                        .message("SUCCESS")
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.OK
        );
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseCommand> userDelete(@RequestBody UserRegisterRequest userRegisterRequest) {
        userManager.delete(userRegisterRequest.getSeq());
        return new ResponseEntity<>(
                ResponseCommand.builder()
                        .code(200)
                        .message("SUCCESS")
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.OK
        );
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseCommand> userUpdate(@RequestBody UserUpdateRequest userUpdateRequest) {
        userManager.update(userUpdateRequest.toCommand(userUpdateRequest));
        return new ResponseEntity<>(
                ResponseCommand.builder()
                        .code(200)
                        .message("SUCCESS")
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.OK
        );
    }
}
