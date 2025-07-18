package com.cns.news_service.dto.response;


import com.cns.news_service.domain.News;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class NewsResponse {
    private String title;
    private String description;
    private String link;
    private String thumbnail;
    private String category;
    private boolean favorite;
    private String pubDate;

    public static NewsResponse from(News news) {
        return NewsResponse.builder()
                .title(news.getTitle())
                .description(news.getDescription())
                .link(news.getLink())
                .thumbnail(news.getThumbnail())
                .category(news.getCategory())
                .build();
    }
}
