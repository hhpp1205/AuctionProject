package com.sjcu.auction.process.user.service;

import com.sjcu.auction.process.common.exception.ErrorCode;
import com.sjcu.auction.process.common.exception.ProcessException;
import com.sjcu.auction.process.user.domain.UserRepository;
import com.sjcu.auction.process.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final LoginSupporter loginSupporter;

    public boolean login(User user) {
        User findUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new ProcessException(ErrorCode.USER_NOT_FOUND));

        boolean loginResult = loginSupporter.validatePassword(user.getPassword(), findUser.getPassword());

        user.setEmptyPassword();

        return loginResult;
    }
}
