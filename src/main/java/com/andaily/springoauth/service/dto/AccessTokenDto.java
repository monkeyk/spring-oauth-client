package com.andaily.springoauth.service.dto;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * 15-5-18
 * <p/>
 * {"access_token":"d580fbfe-da2c-4840-8b66-848168ad8d62","token_type":"bearer","refresh_token":"9406e12f-d62e-42bd-ad40-0206d94ae776","expires_in":43199,"scope":"read write"}
 *
 * @author Shengzhao Li
 */
public class AccessTokenDto implements Serializable {

    private String accessToken;
    private String tokenType;
    private String refreshToken;
    private String scope;

    private int expiresIn;


    //Error if have from oauth server
    private String errorDescription;
    private String error;

    public AccessTokenDto() {
    }

    public AccessTokenDto(int errorCode, String errorDescription) {
        this.error = String.valueOf(errorCode);
        this.errorDescription = errorDescription;
    }


    public boolean error() {
        return StringUtils.isNotEmpty(error) || StringUtils.isNotEmpty(errorDescription);
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{accessToken='").append(accessToken).append('\'');
        sb.append(", tokenType='").append(tokenType).append('\'');
        sb.append(", refreshToken='").append(refreshToken).append('\'');
        sb.append(", scope='").append(scope).append('\'');
        sb.append(", expiresIn=").append(expiresIn);
        sb.append(", errorDescription='").append(errorDescription).append('\'');
        sb.append(", error='").append(error).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
