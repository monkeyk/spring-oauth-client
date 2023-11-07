package com.andaily.springoauth.service;

import com.andaily.springoauth.service.dto.*;

/**
 * @author Shengzhao Li
 */

public interface OauthService {


    AccessTokenDto retrieveAccessTokenDto(AuthAccessTokenDto tokenDto);

    AuthAccessTokenDto createAuthAccessTokenDto(AuthCallbackDto callbackDto);

    /**
     * @deprecated use loadUserinfoDto replaced from v2.0.0
     */
    UserDto loadUnityUserDto(String accessToken);

    AccessTokenDto retrievePasswordAccessTokenDto(AuthAccessTokenDto authAccessTokenDto);

    AccessTokenDto refreshAccessTokenDto(RefreshAccessTokenDto refreshAccessTokenDto);

    AccessTokenDto retrieveCredentialsAccessTokenDto(AuthAccessTokenDto authAccessTokenDto);

    /**
     * load /userinfo
     *
     * @since 2.0.0
     */
    UserinfoDto loadUserinfoDto(String accessToken);

    /**
     * save client details
     *
     * @since 2.0.0
     */
    String saveClientDetails(ClientDetailsDto clientDetailsDto);

    /**
     * 加载保存的 client details
     * 未保存返回 null
     *
     * @return ClientDetailsDto
     * @since 2.0.0
     */
    ClientDetailsDto loadClientDetails();
}