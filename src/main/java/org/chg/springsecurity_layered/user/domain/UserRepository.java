package org.chg.springsecurity_layered.user.domain;

import org.chg.springsecurity_layered.user.presentation.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
