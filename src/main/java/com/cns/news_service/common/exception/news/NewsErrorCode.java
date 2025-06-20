package com.cns.news_service.common.exception.news;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum NewsErrorCode{
    NEWS_PARSING_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "뉴스 정보를 불러올 수 없습니다.", "1004");

    private final HttpStatus status;
    private final String message;
    private final String errorCode;

}
