package org.chg.springsecurity_layered.user.domain;

import org.chg.springsecurity_layered.user.presentation.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoReader extends JpaRepository<User, String> {
}
