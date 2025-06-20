package com.cns.news_service.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BadParameter extends ClientError {
    public BadParameter(String message){
        this.errorCode = "Bad Parameter";
        this.errorMessage = message;
    }
}
