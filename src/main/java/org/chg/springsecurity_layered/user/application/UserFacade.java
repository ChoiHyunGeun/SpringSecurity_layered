package org.chg.springsecurity_layered.user.application;

import org.chg.springsecurity_layered.user.domain.User;
import org.chg.springsecurity_layered.user.domain.UserRepository;
import org.chg.springsecurity_layered.user.presentation.UserRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

//직접 userRepository를 implements 하는 거랑 생성자 주입하는 것의 차이를 반드시 공부하기
// GPT에 질문한 내용 있음
@Service
public class UserFacade { 
    private final UserRepository userRepository;

    public UserFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 현재 왜 있는 계층인지 모르겠음. 일단 구현을 하고 추후 계층을 자세히 분석하여 수정하도록 함
    public void save(UserRequest userRequest) {
        userRepository.save(UserRequest.toEntity(userRequest));
    }

    public Optional<User> findById(String userId) {
        return userRepository.findById(userId);
    }
}
