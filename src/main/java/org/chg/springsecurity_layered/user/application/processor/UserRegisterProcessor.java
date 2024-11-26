package org.chg.springsecurity_layered.user.application.processor;

import org.chg.springsecurity_layered.user.application.command.UserRegisterCommand;
import org.chg.springsecurity_layered.user.domain.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterProcessor {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegisterProcessor(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void execute(UserRegisterCommand userRegisterCommand) {
        userRegisterCommand.setPassword(passwordEncoder.encode(userRegisterCommand.getPassword()));
        userRepository.save(userRegisterCommand.toEntity(userRegisterCommand));
    }
}
