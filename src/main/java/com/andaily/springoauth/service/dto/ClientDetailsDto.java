package com.andaily.springoauth.service.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;

/**
 * 2023/11/7 15:00
 * <p>
 * client details  data
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
public class ClientDetailsDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 34710937786537773L;

    @NotBlank(message = "clientId is required")
    private String clientId;

    @NotBlank(message = "clientSecret is required")
    private String clientSecret;


    /**
     * OIDC scope 值, 多个由逗号分隔
     * 如: openid,profile,email
     */
    @NotBlank(message = "scopes is required")
    private String scopes = "openid";

    /**
     * 授权支持的 grant_type (OAuth2.1), 多个由逗号分隔
     * 如: authorization_code,refresh_token
     */
    @NotBlank(message = "grantTypes is required")
    private String authorizationGrantTypes;

    /**
     * OAuth2 认证后回调uri， 一般传递code, 多个由逗号分隔
     * The re-direct URI(s) established during registration (optional, comma separated).
     */
    @NotBlank(message = "redirectUris is required")
    private String redirectUris;

    /**
     * 是否支持 PKCE
     */
    private boolean supportPkce;


    public ClientDetailsDto() {
    }


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public String getAuthorizationGrantTypes() {
        return authorizationGrantTypes;
    }

    public void setAuthorizationGrantTypes(String authorizationGrantTypes) {
        this.authorizationGrantTypes = authorizationGrantTypes;
    }

    public String getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    public boolean isSupportPkce() {
        return supportPkce;
    }

    public void setSupportPkce(boolean supportPkce) {
        this.supportPkce = supportPkce;
    }


    @Override
    public String toString() {
        return "{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret=***" +
                ", scopes='" + scopes + '\'' +
                ", authorizationGrantTypes='" + authorizationGrantTypes + '\'' +
                ", redirectUris='" + redirectUris + '\'' +
                ", supportPkce=" + supportPkce +
                '}';
    }
}
