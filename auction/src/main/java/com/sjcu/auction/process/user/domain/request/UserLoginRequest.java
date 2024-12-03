package com.sjcu.auction.process.user.domain.request;

import com.sjcu.auction.process.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {
    private String username;
    private String password;

    public User toEntity() {
        return new User(username, password);
    }
}
