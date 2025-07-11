package com.cns.news_service.client;

import com.cns.news_service.client.config.FeignLogConfig;
import com.cns.news_service.dto.response.FavoriteResponseDto;
import com.cns.news_service.dto.response.InterestResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "backend-user-service", url = "http://backend-user-service:8080",
        path = "/api/user/v1", configuration = FeignLogConfig.class)
public interface UserServiceClient {
    @GetMapping("/favorites/{userId}")
    List<FavoriteResponseDto> getFavorites(@PathVariable("userId") Long userId);

    @GetMapping("/interest/{userId}")
    List<InterestResponseDto> getInterests(@PathVariable("userId") Long userId);

}
