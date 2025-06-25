package com.cns.news_service.api.controller;

import com.cns.news_service.common.response.ApiResponse;
import com.cns.news_service.common.util.GatewayRequestHeaderUtils;
import com.cns.news_service.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news/test")
public class NewsAiTestController {

    private final NewsService newsService;

    @GetMapping("/keyword")
    public ResponseEntity<ApiResponse> getKeyword() {
        Long userId = GatewayRequestHeaderUtils.getUserIdOrThrowException();
        String keyword = newsService.getKeyword(userId);

        return ResponseEntity.ok(ApiResponse.success("Ai 키워드 생성 : ", keyword));
    }
}
