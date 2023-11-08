package com.andaily.springoauth.service.dto;

import org.apache.commons.lang.StringUtils;

import java.io.Serial;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Shengzhao Li
 */
public class AuthorizationCodeDto implements Serializable {


    @Serial
    private static final long serialVersionUID = -1351480384638774862L;

    private String userAuthorizationUri;
    private String responseType;
    private String scope;
    private String clientId;
    private String redirectUri;
    private String state;

    /**
     * PKCE flow used
     *
     * @since 2.0.0
     */
    private String codeVerifier;
    private String codeChallengeMethod;
    private String codeChallenge;


    public AuthorizationCodeDto() {
    }

    public String getCodeChallengeMethod() {
        return codeChallengeMethod;
    }

    public void setCodeChallengeMethod(String codeChallengeMethod) {
        this.codeChallengeMethod = codeChallengeMethod;
    }

    public String getCodeChallenge() {
        return codeChallenge;
    }

    public void setCodeChallenge(String codeChallenge) {
        this.codeChallenge = codeChallenge;
    }

    public String getCodeVerifier() {
        return codeVerifier;
    }

    public void setCodeVerifier(String codeVerifier) {
        this.codeVerifier = codeVerifier;
    }

    public String getUserAuthorizationUri() {
        return userAuthorizationUri;
    }

    public void setUserAuthorizationUri(String userAuthorizationUri) {
        this.userAuthorizationUri = userAuthorizationUri;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * http://localhost:8080/oauth2/authorize?client_id=unity-client&redirect_uri=http%3a%2f%2flocalhost%3a8080%2funity%2fdashboard.htm&response_type=code&scope=read
     */
    public String getFullUri() {
        String redirect = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);
        if (StringUtils.isNotBlank(codeChallenge)) {
            // v2.0.0 added PKCE request
            return String.format("%s?response_type=%s&scope=%s&client_id=%s&redirect_uri=%s&state=%s&code_challenge_method=%s&code_challenge=%s",
                    userAuthorizationUri, responseType, scope, clientId, redirect, state, codeChallengeMethod, codeChallenge);
        } else {
            return String.format("%s?response_type=%s&scope=%s&client_id=%s&redirect_uri=%s&state=%s", userAuthorizationUri, responseType, scope, clientId, redirect, state);
        }
    }
}