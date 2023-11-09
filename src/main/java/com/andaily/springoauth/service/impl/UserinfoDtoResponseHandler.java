package com.andaily.springoauth.service.impl;

import com.andaily.springoauth.infrastructure.httpclient.MkkHttpResponse;
import com.andaily.springoauth.service.dto.UserinfoDto;

/**
 * 2023-11-07
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
public class UserinfoDtoResponseHandler extends AbstractResponseHandler<UserinfoDto> {


    private UserinfoDto userinfoDto;

    public UserinfoDtoResponseHandler() {
    }

    /**
    * Response is JSON or  XML (failed)
    *
    *  Error data:
    *  <oauth><error_description>Invalid access token: 3420d0e0-ed77-45e1-8370-2b55af0a62e8</error_description><error>invalid_token</error></oauth>
    *
    * */
    @Override
    public void handleResponse(MkkHttpResponse response) {
        if (response.isResponse200()) {
            this.userinfoDto = responseToDto(response, new UserinfoDto());
        } else {
            this.userinfoDto = responseToErrorDto(response, new UserinfoDto());
        }
    }


    public UserinfoDto getUserinfoDto() {
        return userinfoDto;
    }


}
