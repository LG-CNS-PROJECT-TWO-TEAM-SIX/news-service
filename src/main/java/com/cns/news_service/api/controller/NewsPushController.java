package com.cns.news_service.api.controller;

import com.cns.news_service.common.response.ApiResponse;
import com.cns.news_service.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/news")
public class NewsPushController {

    private final NewsService newsService;

    @PostMapping("/push")
    public ResponseEntity<ApiResponse> pushNews() {
        newsService.pushNewsHeadline();
        return ResponseEntity.ok(ApiResponse.success("헤드라인 뉴스 수동 push 완료"));
    }
}
