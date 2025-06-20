package com.cns.news_service.common.exception.handler;

import com.cns.news_service.common.exception.BadParameter;
import com.cns.news_service.common.exception.ClientError;
import com.cns.news_service.common.exception.NotFound;
import com.cns.news_service.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Order(value = 1)
@RestControllerAdvice
public class ApiCommonAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadParameter.class)
    public ApiResponse handleBadParameter(BadParameter e) {
        return ApiResponse.error(e.getErrorMessage(), e.getErrorCode());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFound.class)
    public ApiResponse handleNotFound(NotFound e) {
        return ApiResponse.error(e.getErrorMessage(), e.getErrorCode());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClientError.class)
    public ApiResponse handleClientError(ClientError e) {
        return ApiResponse.error(e.getErrorMessage(), e.getErrorCode());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse handleValidation(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        String message = result.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .findFirst()
                .orElse("잘못된 요청입니다.");
        return ApiResponse.error(message, "ParameterNotValid");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiResponse handleServerError(Exception e) {
        log.error("서버 에러 발생", e);
        return ApiResponse.error("서버 에러가 발생했습니다.", "ServerError");
    }
}
