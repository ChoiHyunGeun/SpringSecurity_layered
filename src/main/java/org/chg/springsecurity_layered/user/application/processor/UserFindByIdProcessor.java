package org.chg.springsecurity_layered.user.application.processor;

import org.chg.springsecurity_layered.user.domain.User;
import org.chg.springsecurity_layered.user.domain.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserFindByIdProcessor {
    private final UserRepository userRepository;

    public UserFindByIdProcessor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> execute(int id) {
        return userRepository.findById(id);
    }
}
