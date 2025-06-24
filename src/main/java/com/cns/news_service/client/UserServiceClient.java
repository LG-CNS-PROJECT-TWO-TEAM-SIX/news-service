package com.cns.news_service.client;

import com.cns.news_service.client.config.FeignConfig;
import com.cns.news_service.dto.response.FavoriteResponseDto;
import com.cns.news_service.dto.response.InterestResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "backend-user-service", url = "http://backend-user-service:8080", configuration = FeignConfig.class)
public interface UserServiceClient {
    @GetMapping("/api/user/v1/favorites/{userId}")
    List<FavoriteResponseDto> getFavorites(@PathVariable("userId") Long userId);

    @GetMapping("/api/user/v1/interest/{userId}")
    List<InterestResponseDto> getInterests(@PathVariable("userId") Long userId);

}
