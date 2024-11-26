package org.chg.springsecurity_layered.user.application.processor;

import org.chg.springsecurity_layered.user.application.command.UserUpdateCommand;
import org.chg.springsecurity_layered.user.domain.User;
import org.chg.springsecurity_layered.user.domain.UserRepository;
import org.chg.springsecurity_layered.user.domain.exception.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateProcessor {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserUpdateProcessor(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void execute(UserUpdateCommand userUpdateCommand) {
        if (!userRepository.existsById(userUpdateCommand.getSeq())) {
            throw new UserNotFoundException();
        }
        User user = userRepository.getReferenceById(userUpdateCommand.getSeq());
        //비밀번호 암호화
        userUpdateCommand.setPassword(passwordEncoder.encode(userUpdateCommand.getPassword()));
        //권한 수정
        user.setPassword(userUpdateCommand.getPassword());
        user.setUserRole(userUpdateCommand.getUserRole());
    }
}
