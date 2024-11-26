package org.chg.springsecurity_layered.user.infrastructure;

import org.chg.springsecurity_layered.user.domain.User;
import org.chg.springsecurity_layered.user.domain.UserRepository;
import org.chg.springsecurity_layered.user.infrastructure.jpa.JpaUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryAdapter(final JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public void save(User user) {
        jpaUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(int seq) {
        return jpaUserRepository.findById(seq);
    }

    @Override
    public Optional<User> findByUsername(String userId) {
        return jpaUserRepository.findByUsername(userId);
    }

    @Override
    public void deleteById(int seq) {
        jpaUserRepository.deleteById(seq);
    }

    @Override
    public User getReferenceById(int seq) {
        return jpaUserRepository.getReferenceById(seq);
    }

    @Override
    public Boolean existsById(int seq) {
        return jpaUserRepository.existsById(seq);
    }
}
