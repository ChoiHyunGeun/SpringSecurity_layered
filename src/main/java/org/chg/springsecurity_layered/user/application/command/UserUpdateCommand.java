package org.chg.springsecurity_layered.user.application.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.chg.springsecurity_layered.user.domain.User;

@Getter
@Setter
@Builder
public class UserUpdateCommand {
    int seq;
    String password;
    String userRole;
}
