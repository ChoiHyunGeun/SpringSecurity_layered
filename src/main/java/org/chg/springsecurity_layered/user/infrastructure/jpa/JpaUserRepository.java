package org.chg.springsecurity_layered.user.infrastructure.jpa;

import org.chg.springsecurity_layered.user.domain.User;
import org.chg.springsecurity_layered.user.presentation.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
