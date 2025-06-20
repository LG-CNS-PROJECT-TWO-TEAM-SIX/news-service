package com.cns.news_service.api.controller;

import com.cns.news_service.common.response.ApiResponse;
import com.cns.news_service.common.util.GatewayRequestHeaderUtils;
import com.cns.news_service.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/news")
@Tag(name = "뉴스 조회 API")
public class NewsQueryController {

    private final NewsService newsService;

    @Operation(summary = "헤드라인 뉴스 목록 조회", description = "최신 헤드라인 뉴스 목록을 조회합니다.")
    @GetMapping
    public ResponseEntity<ApiResponse> getNews() {
        Long userId = GatewayRequestHeaderUtils.getUserIdOrThrowException();
        return ResponseEntity.ok(ApiResponse.success(newsService.getNews(userId)));
    }

    @Operation(summary = "키워드 기반 뉴스 검색", description = "사용자가 입력한 키워드로 뉴스 목록을 검색합니다.")
    @GetMapping("/search/{keyword}")
    public ResponseEntity<ApiResponse> searchNews(
            @Parameter(description = "검색할 키워드", example = "기후 변화")@PathVariable String keyword) {
        Long userId = GatewayRequestHeaderUtils.getUserIdOrThrowException();
        return ResponseEntity.ok(ApiResponse.success(newsService.getSearchNews(keyword, userId)));
    }
}
