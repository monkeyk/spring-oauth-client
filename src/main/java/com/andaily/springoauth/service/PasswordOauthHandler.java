package com.andaily.springoauth.service;

import com.andaily.springoauth.service.dto.AccessTokenDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handle 'password'  type actions
 * <p/>
 * http://localhost:8080/oauth/token?client_id=mobile-client&client_secret=mobile&grant_type=password&scope=read,write&username=mobile&password=mobile
 *
 * @author Shengzhao Li
 */
public class PasswordOauthHandler {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordOauthHandler.class);

    public PasswordOauthHandler() {
    }

    /**
     * Step 1:
     * Get access token from Oauth server
     *
     * @return AccessTokenDto
     */
    public AccessTokenDto getAccessToken() {


        return null;
    }


}