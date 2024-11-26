package com.sjcu.auction.process.user.domain.request;

import com.sjcu.auction.process.user.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModRequest {
    private String password;

    public User toEntity() {
        return new User("", password);
    }
}
