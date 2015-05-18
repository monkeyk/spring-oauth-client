package com.andaily.springoauth.service.impl;

import com.andaily.springoauth.infrastructure.httpclient.HttpClientExecutor;
import com.andaily.springoauth.service.OauthService;
import com.andaily.springoauth.service.dto.AccessTokenDto;
import com.andaily.springoauth.service.dto.AuthAccessTokenDto;
import com.andaily.springoauth.service.dto.AuthCallbackDto;
import com.andaily.springoauth.web.GetAccessTokenResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * 15-5-18
 *
 * @author Shengzhao Li
 */
@Service("oauthService")
public class OauthServiceImpl implements OauthService {

    private static final Logger LOG = LoggerFactory.getLogger(OauthServiceImpl.class);


    @Value("#{properties['access-token-uri']}")
    private String accessTokenUri;


    @Override
    public AccessTokenDto retrieveAccessTokenDto(AuthAccessTokenDto tokenDto) throws UnsupportedEncodingException {
        final String fullUri = tokenDto.getFullUri();
        LOG.debug("Get access_token URL: {}", fullUri);

        HttpClientExecutor executor = new HttpClientExecutor(fullUri);
        GetAccessTokenResponseHandler responseHandler = new GetAccessTokenResponseHandler();
        executor.execute(responseHandler);
        return responseHandler.getAccessTokenDto();
    }

    @Override
    public AuthAccessTokenDto createAuthAccessTokenDto(AuthCallbackDto callbackDto) {
        return new AuthAccessTokenDto()
                .setAccessTokenUri(accessTokenUri)
                .setCode(callbackDto.getCode());
    }
}
