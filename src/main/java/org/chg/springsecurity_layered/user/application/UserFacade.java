package org.chg.springsecurity_layered.user.application;

import jakarta.persistence.EntityNotFoundException;
import org.chg.springsecurity_layered.user.domain.User;
import org.chg.springsecurity_layered.user.domain.UserRepository;
import org.chg.springsecurity_layered.user.presentation.UserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//직접 userRepository를 implements 하는 거랑 생성자 주입하는 것의 차이를 반드시 공부하기
// GPT에 질문한 내용 있음
// Tansactional 선언 위치에 따라 update가 에러 발생 여부가 달라짐. 상세하게 공부하기
@Transactional 
@Service
public class UserFacade { 
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserFacade(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(UserRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(UserRequest.toEntity(userRequest));
    }

    public Optional<User> findById(int seq) {
        return userRepository.findById(seq);
    }

    public Optional<User> findByUsername(String userId) {
        return userRepository.findByUsername(userId);
    }

    public void delete(UserRequest userRequest) {
        if (!userRepository.existsById(userRequest.getSeq())) {
            throw new EntityNotFoundException("Entity with ID " + userRequest.getUserId() + " not found");
        }
        userRepository.deleteById(userRequest.getSeq());
    }

    //getReferenceById 와 findById의 차이점 알기
    public void update(UserRequest userRequest) {
        User user = userRepository.getReferenceById(userRequest.getSeq());
        //비밀번호 암호화
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setPassword(userRequest.getPassword());
    }
}
