package com.cns.news_service.common.exception.handler;

import com.cns.news_service.common.exception.news.NewsErrorCode;
import com.cns.news_service.common.exception.news.NewsException;
import com.cns.news_service.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionResponseHandler {
    @ExceptionHandler(NewsException.class)
    public ResponseEntity<ApiResponse> handleNewsException(NewsException e){
        NewsErrorCode error = e.getNewsErrorCode();
        return ResponseEntity
                .status(error.getStatus())
                .body(ApiResponse.error(error.getMessage(), error.getErrorCode()));
    }
}
