package com.andaily.springoauth.service;

import com.andaily.springoauth.service.dto.AccessTokenDto;
import com.andaily.springoauth.service.dto.AuthAccessTokenDto;
import com.andaily.springoauth.service.dto.AuthCallbackDto;
import com.andaily.springoauth.service.dto.UserDto;

import java.io.UnsupportedEncodingException;

/**
 * @author Shengzhao Li
 */

public interface OauthService {


    AccessTokenDto retrieveAccessTokenDto(AuthAccessTokenDto tokenDto) throws UnsupportedEncodingException;

    AuthAccessTokenDto createAuthAccessTokenDto(AuthCallbackDto callbackDto);

    UserDto loadUnityUserDto(String accessToken);
}