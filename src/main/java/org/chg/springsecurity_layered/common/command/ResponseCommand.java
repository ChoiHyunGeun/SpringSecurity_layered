package org.chg.springsecurity_layered.common.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ResponseCommand {
    int code;
    String message;
    LocalDateTime timestamp;
}
