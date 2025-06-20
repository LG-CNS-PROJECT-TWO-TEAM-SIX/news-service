package com.cns.news_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class FavoriteResponseDto {
    private Long id;
    private String newsTitle;
    private String newsSummary;
    private String newsLink;
    private String newsThumbnail;
    private String newsCategory;

}
