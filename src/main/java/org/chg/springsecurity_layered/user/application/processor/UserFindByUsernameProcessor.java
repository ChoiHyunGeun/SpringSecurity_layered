package org.chg.springsecurity_layered.user.application.processor;

import org.chg.springsecurity_layered.user.domain.User;
import org.chg.springsecurity_layered.user.domain.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserFindByUsernameProcessor {
    private final UserRepository userRepository;

    public UserFindByUsernameProcessor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> execute(String username) {
        return userRepository.findByUsername(username);
    }
}
