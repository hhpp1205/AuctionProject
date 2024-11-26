package com.sjcu.auction.process.user.service;

import com.sjcu.auction.process.user.domain.UserRepository;
import com.sjcu.auction.process.user.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {
        User user = new User("userName", "password");
        User saveUser = userRepository.save(user);

        User findUser = userRepository.findById(saveUser.getUserId()).get();
        findUser.updatePassword("newPassword");

    }

}