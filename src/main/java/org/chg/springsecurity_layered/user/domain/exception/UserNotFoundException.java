package org.chg.springsecurity_layered.user.domain.exception;

import org.chg.springsecurity_layered.common.exception.ErrorCode;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND.getMessage());
    }
}
