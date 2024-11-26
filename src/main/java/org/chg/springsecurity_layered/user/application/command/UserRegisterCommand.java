package org.chg.springsecurity_layered.user.application.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.chg.springsecurity_layered.user.domain.User;

@Setter
@Getter
@Builder
public class UserRegisterCommand {
    int seq;
    String userId;
    String password;
    String userRole;

    public User toEntity(UserRegisterCommand userRegisterCommand) {
        return User.builder()
                .username(userRegisterCommand.getUserId())
                .password(userRegisterCommand.getPassword())
                .userRole(userRegisterCommand.getUserRole())
                .build();
    }
}
