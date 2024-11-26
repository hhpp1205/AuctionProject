package com.sjcu.auction.process.user.service;

import com.sjcu.auction.process.user.domain.UserRepository;
import com.sjcu.auction.process.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElse(new User());
    }

    public User updateUser(Long userId, User user) {
        User originUser = userRepository.findById(userId).orElse(new User());
        originUser.updatePassword(user.getPassword());
        return userRepository.save(originUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
