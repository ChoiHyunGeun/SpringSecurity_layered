package org.chg.springsecurity_layered.user.application.facade;

import org.chg.springsecurity_layered.user.application.command.UserRegisterCommand;
import org.chg.springsecurity_layered.user.application.command.UserUpdateCommand;
import org.chg.springsecurity_layered.user.application.processor.*;
import org.chg.springsecurity_layered.user.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//직접 userRepository를 implements 하는 거랑 생성자 주입하는 것의 차이를 반드시 공부하기
// GPT에 질문한 내용 있음
// Tansactional 선언 위치에 따라 update가 에러 발생 여부가 달라짐. 상세하게 공부하기
@Transactional 
@Service
public class UserManager {
    private final UserRegisterProcessor userRegisterProcessor;
    private final UserFindByIdProcessor userFindByIdProcessor;
    private final UserFindByUsernameProcessor userFindByUsernameProcessor;
    private final UserDeleteProcessor userDeleteProcessor;
    private final UserUpdateProcessor userUpdateProcessor;

    public UserManager(
            UserRegisterProcessor userRegisterProcessor,
            UserFindByIdProcessor userFindByIdProcessor,
            UserFindByUsernameProcessor userFindByUsernameProcessor,
            UserDeleteProcessor userDeleteProcessor,
            UserUpdateProcessor userUpdateProcessor) {
        this.userRegisterProcessor = userRegisterProcessor;
        this.userFindByIdProcessor = userFindByIdProcessor;
        this.userFindByUsernameProcessor = userFindByUsernameProcessor;
        this.userDeleteProcessor = userDeleteProcessor;
        this.userUpdateProcessor = userUpdateProcessor;
    }

    public void save(UserRegisterCommand userRegisterCommand) {
        userRegisterProcessor.execute(userRegisterCommand);
    }

    public Optional<User> findById(int seq) {
        return userFindByIdProcessor.execute(seq);
    }

    public Optional<User> findByUsername(String userId) {
        return userFindByUsernameProcessor.execute(userId);
    }

    public void delete(int seq) {
        userDeleteProcessor.execute(seq);
    }

    //getReferenceById 와 findById의 차이점 알기
    public void update(UserUpdateCommand userUpdateCommand) {
        userUpdateProcessor.execute(userUpdateCommand);
    }
}
