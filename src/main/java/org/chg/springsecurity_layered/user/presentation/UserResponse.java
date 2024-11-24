package org.chg.springsecurity_layered.user.presentation;

import lombok.Builder;
import lombok.Getter;

@Builder
public class UserResponse {
    @Getter String userId;
    @Getter String password;
}
