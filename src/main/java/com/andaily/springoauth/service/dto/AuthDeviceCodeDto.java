package com.andaily.springoauth.service.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 2023-11-09
 * <p/>
 * http://localhost:8080/oauth2/device_authorization?client_id=xxxx&client_secret=xxx&scope=openid
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
public class AuthDeviceCodeDto implements Serializable {


    @Serial
    private static final long serialVersionUID = 3398358846980534154L;

    private String deviceAuthorizeUrl;

    private String clientId;

    private String clientSecret;


    private String scope;


    public AuthDeviceCodeDto() {
    }

    public String getDeviceAuthorizeUrl() {
        return deviceAuthorizeUrl;
    }

    public void setDeviceAuthorizeUrl(String deviceAuthorizeUrl) {
        this.deviceAuthorizeUrl = deviceAuthorizeUrl;
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

    public AuthDeviceCodeDto setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public AuthDeviceCodeDto setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }


    /**
     * http://localhost:8080/oauth2/device_authorization?client_id=xxxx&client_secret=xxx&scope=openid
     */
    public Map<String, String> getAuthParams() {
        Map<String, String> map = new HashMap<>();
        map.put("client_id", clientId);
        map.put("client_secret", clientSecret);
        map.put("scope", scope);

        return map;
    }

}
