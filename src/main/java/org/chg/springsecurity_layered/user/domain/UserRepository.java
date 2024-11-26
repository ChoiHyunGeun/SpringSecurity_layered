package org.chg.springsecurity_layered.user.domain;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findById(int seq);
    Optional<User> findByUsername(String userId);
    void deleteById(int seq);
    User getReferenceById(int seq);
    Boolean existsById(int seq);
}
