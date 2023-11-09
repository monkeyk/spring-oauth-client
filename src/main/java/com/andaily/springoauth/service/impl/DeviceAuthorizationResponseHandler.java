package com.andaily.springoauth.service.impl;

import com.andaily.springoauth.infrastructure.httpclient.MkkHttpResponse;
import com.andaily.springoauth.service.dto.DeviceAuthorizationDto;

/**
 * 2023-11-09
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
public class DeviceAuthorizationResponseHandler extends AbstractResponseHandler<DeviceAuthorizationDto> {


    private DeviceAuthorizationDto deviceAuthorizationDto;

    public DeviceAuthorizationResponseHandler() {
    }

    @Override
    public void handleResponse(MkkHttpResponse response) {
        if (response.isResponse200()) {
            this.deviceAuthorizationDto = responseToDto(response, new DeviceAuthorizationDto());
        } else {
            this.deviceAuthorizationDto = responseToErrorDto(response, new DeviceAuthorizationDto());
        }
    }


    public DeviceAuthorizationDto getDeviceAuthorizationDto() {
        return deviceAuthorizationDto;
    }
}
