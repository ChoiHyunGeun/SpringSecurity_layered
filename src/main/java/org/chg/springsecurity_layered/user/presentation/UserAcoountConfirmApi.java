package org.chg.springsecurity_layered.user.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserAcoountConfirmApi {
    @PostMapping("/a")
    public ResponseEntity<?> findUserInfo() {


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
