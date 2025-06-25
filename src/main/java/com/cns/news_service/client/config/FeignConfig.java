//package com.cns.news_service.client.config;
//
//import com.cns.news_service.common.util.GatewayRequestHeaderUtils;
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//@Configuration
//public class FeignConfig implements RequestInterceptor {
//
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//
//        if (attributes != null) {
//            String userId = GatewayRequestHeaderUtils.getRequestHeaderParamAsString("X-Auth-UserId");
//            String clientAddr = GatewayRequestHeaderUtils.getRequestHeaderParamAsString ("X-Client-Address");
//            String clientDevice = GatewayRequestHeaderUtils.getRequestHeaderParamAsString("X-Client-Device");
//
//            if (userId != null) requestTemplate.header("X-Auth-UserId", userId);
//            if (clientAddr != null) requestTemplate.header("X-Client-Address", clientAddr);
//            if (clientDevice != null) requestTemplate.header("X-Client-Device", clientDevice);
//        }
//
//    }
//}
