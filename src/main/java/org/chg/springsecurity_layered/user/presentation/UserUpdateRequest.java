package org.chg.springsecurity_layered.user.presentation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.chg.springsecurity_layered.user.application.command.UserRegisterCommand;
import org.chg.springsecurity_layered.user.application.command.UserUpdateCommand;

@Setter
@Getter
public class UserUpdateRequest {
    int seq;
    String password;
    String userRole;

    public UserUpdateCommand toCommand(UserUpdateRequest userUpdateRequest) {
        return UserUpdateCommand.builder()
                .seq(userUpdateRequest.getSeq())
                .password(userUpdateRequest.getPassword())
                .userRole(userUpdateRequest.getUserRole())
                .build();
    }
}
