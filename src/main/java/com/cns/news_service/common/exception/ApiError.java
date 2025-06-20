package com.cns.news_service.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //상속받은 것을 만들어서 쓰려고 함
public class ApiError extends RuntimeException{
    protected String errorCode;
    protected String errorMessage;
}
