package org.chg.springsecurity_layered.user.presentation;

import lombok.Getter;
import lombok.Setter;
import org.chg.springsecurity_layered.user.application.command.UserRegisterCommand;

@Setter
@Getter
public class UserRegisterRequest {
    int seq;
    String userId;
    String password;
    String userRole;

    public UserRegisterCommand toCommand(UserRegisterRequest userRegisterRequest) {
        return UserRegisterCommand.builder()
                .userId(userRegisterRequest.getUserId())
                .password(userRegisterRequest.getPassword())
                .userRole(userRegisterRequest.getUserRole())
                .build();
    }
}
