package com.cns.news_service.api.controller;

import com.cns.news_service.common.exception.CustomException;
import com.cns.news_service.common.exception.ErrorCode;
import com.cns.news_service.common.response.ApiResponse;
import com.cns.news_service.dto.request.NewsSummaryRequest;

import com.cns.news_service.dto.response.NewsResultResponse;
import com.cns.news_service.dto.response.NewsSummaryResponse;
import com.cns.news_service.security.PrincipalDetails;


import com.cns.news_service.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
@Tag(name = "AI 뉴스 API", description = "사용자 관심사 기반 뉴스 추천 및 AI 요약 기능 제공")
public class NewAiController {

    private final NewsService newsService;

    @Operation(summary = "AI 추천 뉴스 조회", description = "사용자의 관심사 기반 AI 추천 뉴스를 조회합니다.")
    @GetMapping({"/ai", "/ai/{start}"})
    public ResponseEntity<ApiResponse> getAiRecommendedNews(
            @Parameter(description = "페이징 시작 인덱스 (선택)", example = "11")
            @PathVariable(required = false) Integer start,
            @Parameter(hidden = true)
            @AuthenticationPrincipal PrincipalDetails principal) {

        String prompt = newsService.getKeyword(principal.getId());
        NewsResultResponse response = newsService.getResponse(prompt, start, principal.getId());
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @Operation(summary = "뉴스 본문 AI 요약", description = "뉴스 링크 본문을 AI가 요약하여 제공합니다.")
    @PostMapping("/summary")
    public ResponseEntity<ApiResponse> getSummary(@RequestBody NewsSummaryRequest request) {
        NewsSummaryResponse response = newsService.getSummary(request.getLink());
        if (response == null) {
            throw new CustomException(ErrorCode.NEWS_PARSING_ERROR);
        }
        return ResponseEntity.ok(ApiResponse.success(response));
    }



}
