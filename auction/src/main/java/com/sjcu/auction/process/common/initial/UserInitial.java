package com.sjcu.auction.process.common.initial;

import com.sjcu.auction.process.user.domain.UserRepository;
import com.sjcu.auction.process.user.domain.entity.User;
import com.sjcu.auction.process.user.service.LoginSupporter;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserInitial {

    private final UserRepository userRepository;
    private final LoginSupporter loginSupporter;

    @PostConstruct
    public void init() {
        User user = new User("test", loginSupporter.encodePassword("1234"));
        userRepository.save(user);
    }
}
