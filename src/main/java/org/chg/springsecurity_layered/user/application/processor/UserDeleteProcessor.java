package org.chg.springsecurity_layered.user.application.processor;

import org.chg.springsecurity_layered.user.domain.UserRepository;
import org.chg.springsecurity_layered.user.domain.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteProcessor {
    private final UserRepository userRepository;

    public UserDeleteProcessor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(int seq) {
        if (!userRepository.existsById(seq)) {
            throw new UserNotFoundException();
        }
        userRepository.deleteById(seq);
    }
}
