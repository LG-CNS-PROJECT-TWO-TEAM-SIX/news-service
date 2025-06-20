package com.cns.news_service.common.exception.news;

import com.cns.news_service.common.exception.ApiError;
import lombok.Getter;

@Getter
public class NewsException extends ApiError {

    private final NewsErrorCode newsErrorCode;

    public NewsException(NewsErrorCode errorCode) {

        super(errorCode.getErrorCode(), errorCode.getMessage());
        this.newsErrorCode = errorCode;
    }
    public NewsErrorCode getNewsErrorCode() {
        return this.newsErrorCode;
    }
}

