package org.chg.springsecurity_layered.user.presentation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseCommand {
    int seq;
    String userId;
    String userRole;

    public UserResponseCommand(int seq, String userId, String userRole) {
        this.seq = seq;
        this.userId = userId;
        this.userRole = userRole;
    }
}
