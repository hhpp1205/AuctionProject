package com.sjcu.auction.process.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class ProcessException extends RuntimeException{
    private final ErrorCode errorCode;

}
