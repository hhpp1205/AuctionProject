package com.sjcu.auction.process.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(400, "존재하지 않는 유저입니다.");

    private int code;
    private String message;

}
