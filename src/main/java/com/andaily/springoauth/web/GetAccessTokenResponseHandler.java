package com.andaily.springoauth.web;

import com.andaily.springoauth.infrastructure.httpclient.HttpResponseHandler;
import com.andaily.springoauth.infrastructure.httpclient.MkkHttpResponse;
import com.andaily.springoauth.infrastructure.json.JsonUtils;
import com.andaily.springoauth.service.dto.AccessTokenDto;
import org.apache.http.StatusLine;

/**
 * 15-5-18
 *
 * @author Shengzhao Li
 */
public class GetAccessTokenResponseHandler implements HttpResponseHandler {


    private AccessTokenDto accessTokenDto;

    public GetAccessTokenResponseHandler() {
    }

    @Override
    public void handleResponse(MkkHttpResponse response) {
        if (response.isResponse200()) {
            final String text = response.responseAsString();
            this.accessTokenDto = JsonUtils.textToBean(new AccessTokenDto(), text);
        } else {
            final StatusLine statusLine = response.httpResponse().getStatusLine();
            this.accessTokenDto = new AccessTokenDto(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }
    }

    public AccessTokenDto getAccessTokenDto() {
        return accessTokenDto;
    }
}
