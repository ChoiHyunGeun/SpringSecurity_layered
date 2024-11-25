package org.chg.springsecurity_layered.user.presentation;

import lombok.Getter;
import lombok.Setter;
import org.chg.springsecurity_layered.user.domain.User;

@Setter
@Getter
public class UserRequest {
    String userId;
    String password;
    String userRole;

    public static User toEntity(UserRequest userRequest) {
        return User.builder()
                .userId(userRequest.getUserId())
                .password(userRequest.getPassword())
                .userRole(userRequest.getUserRole())
                .build();
    }
}
