package com.andaily.springoauth.service.dto;

import java.io.Serial;

/**
 * 2023-11-09
 * <p/>
 * <pre>{
 *   "user_code": "GZDF-RJGM",
 *   "device_code": "pRHa9EsrsQiHII3vNRUI-c1XKl7CjE5YaH8CYcES8T_IIX8ezpr_iaLsj0-ZatxzfUNwDbW3_Ej_5m4jy5U9VWB9-vIQUWzuL0L8ea1B3SV690sMUaaaFtVmlW0ZajYK",
 *   "verification_uri_complete": "http://127.0.0.1:8080/oauth2/device_verification?user_code=GZDF-RJGM",
 *   "verification_uri": "http://127.0.0.1:8080/oauth2/device_verification",
 *   "expires_in": 300
 * }</pre>
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
public class DeviceAuthorizationDto extends AbstractOauthDto {


    @Serial
    private static final long serialVersionUID = -7497017423107694265L;

    private String userCode;

    private String deviceCode;

    private String verificationUriComplete;

    private String verificationUri;

    private int expiresIn;


    public DeviceAuthorizationDto() {
    }


    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getVerificationUriComplete() {
        return verificationUriComplete;
    }

    public void setVerificationUriComplete(String verificationUriComplete) {
        this.verificationUriComplete = verificationUriComplete;
    }

    public String getVerificationUri() {
        return verificationUri;
    }

    public void setVerificationUri(String verificationUri) {
        this.verificationUri = verificationUri;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{userCode='").append(userCode).append('\'');
        sb.append(", deviceCode='").append(deviceCode).append('\'');
        sb.append(", verificationUri='").append(verificationUri).append('\'');
        sb.append(", expiresIn=").append(expiresIn);
        sb.append(", errorDescription='").append(errorDescription).append('\'');
        sb.append(", error='").append(error).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
