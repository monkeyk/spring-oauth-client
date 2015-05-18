package com.andaily.springoauth.service.dto;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 15-5-18
 * <p/>
 * http://localhost:8080/oauth/token?client_id=unity-client&client_secret=unity&grant_type=authorization_code&code=zLl170&redirect_uri=http%3a%2f%2flocalhost%3a8080%2funity%2fdashboard.htm
 *
 * @author Shengzhao Li
 */
public class AuthAccessTokenDto implements Serializable {


    private String accessTokenUri;

    private String clientId;

    private String clientSecret;

    private String grantType = "authorization_code";

    private String code;

    private String redirectUri;


    public AuthAccessTokenDto() {
    }

    public String getClientId() {
        return clientId;
    }

    public AuthAccessTokenDto setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public AuthAccessTokenDto setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public String getGrantType() {
        return grantType;
    }

    public AuthAccessTokenDto setGrantType(String grantType) {
        this.grantType = grantType;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AuthAccessTokenDto setCode(String code) {
        this.code = code;
        return this;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public AuthAccessTokenDto setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public String getAccessTokenUri() {
        return accessTokenUri;
    }

    public AuthAccessTokenDto setAccessTokenUri(String accessTokenUri) {
        this.accessTokenUri = accessTokenUri;
        return this;
    }

    /*
    * http://localhost:8080/oauth/token?client_id=unity-client&client_secret=unity&grant_type=authorization_code&code=zLl170&redirect_uri=http%3a%2f%2flocalhost%3a8080%2funity%2fdashboard.htm
    * */
    public String getFullUri() throws UnsupportedEncodingException {
        String redirect = URLEncoder.encode(redirectUri, "UTF-8");
        return String.format("%s?client_id=%s&client_secret=%s&grant_type=%s&redirect_uri=%s&code=%s", accessTokenUri, clientId, clientSecret, grantType, redirect, code);
    }
}
