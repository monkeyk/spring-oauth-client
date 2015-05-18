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

    private String access_token;
    private String token_type;
    private String refresh_token;
    private String scope;

    //Error if have from oauth server
    private String error_description;
    private String error;

    public AccessTokenDto() {
    }

    public AccessTokenDto(int errorCode, String errorDescription) {
        this.error = String.valueOf(errorCode);
        this.error_description = errorDescription;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public boolean error() {
        return StringUtils.isNotEmpty(error) || StringUtils.isNotEmpty(error_description);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
