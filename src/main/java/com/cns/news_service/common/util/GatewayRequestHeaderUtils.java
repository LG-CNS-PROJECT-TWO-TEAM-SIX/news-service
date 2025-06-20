package com.cns.news_service.common.util;

import com.cns.news_service.common.exception.CustomException;
import com.cns.news_service.common.exception.ErrorCode;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class GatewayRequestHeaderUtils {
    public static String getRequestHeaderParamAsString(String key) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return requestAttributes.getRequest().getHeader(key);
    }
    public static Long getUserId() {
        String userId = getRequestHeaderParamAsString("X-Auth-UserId");
        if (userId == null) {
            return null;
        }
        try {
            return Long.parseLong(userId);
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
    }

    public static String getClientDevice() {
        return getRequestHeaderParamAsString("X-Client-Device");
    }

    public static String getClientAddress() {
        return getRequestHeaderParamAsString("X-Client-Address");
    }

    public static Long getUserIdOrThrowException() {
        Long userId = getUserId();
        if (userId == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
        return userId;
    }

    public static String getClientDeviceOrThrowException() {
        String clientDevice = getClientDevice();
        if (clientDevice == null) {
            throw new CustomException(ErrorCode.MISSING_CLIENT_DEVICE);
        }
        return clientDevice;
    }
    public static String getClientAddressOrThrowException() {
        String clientAddress = getClientAddress();
        if (clientAddress == null) {
            throw new CustomException(ErrorCode.MISSING_CLIENT_ADDRESS);
        }
        return clientAddress;
    }
}
