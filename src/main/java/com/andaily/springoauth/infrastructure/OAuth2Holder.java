package com.andaily.springoauth.infrastructure;

import com.andaily.springoauth.infrastructure.httpclient.HttpClientExecutor;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 2023/11/6 23:19
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
@Component
public class OAuth2Holder implements InitializingBean {

    private static final Logger LOG = LoggerFactory.getLogger(OAuth2Holder.class);


    /**
     * spring-oauth-server or myoidc-server host
     */
    @Value("${oauth2.server.host:http://127.0.0.1:8080}")
    private String oauth2ServerHost;

    /**
     * spring-oauth-server or myoidc-server well-known url: .well-known/openid-configuration
     */
    @Value("${oauth2.server.well-known.url:.well-known/openid-configuration}")
    private String wellKnownUrl;


    /**
     * spring-oauth-server or myoidc-server token url:  oauth2/token
     */
    private static String tokenUrl;

    /**
     * spring-oauth-server or myoidc-server authorize url:  oauth2/authorize
     */
    private static String authorizeUrl;

    /**
     * spring-oauth-server or myoidc-server device authorize url:  oauth2/device_authorization
     */
    private static String deviceAuthorizeUrl;


    /**
     * spring-oauth-server or myoidc-server userinfo url:  /userinfo
     */
    private static String userinfoUrl;


    /**
     * spring-oauth-server or myoidc-server jwks url:  /oauth2/jwks
     */
    private static String jwksUrl;


    /**
     * spring-oauth-server or myoidc-server jwks url:  /oauth2/revoke
     */
    private static String revokeUrl;

    /**
     * spring-oauth-server or myoidc-server jwks url:  /oauth2/introspect
     */
    private static String introspectUrl;

    /**
     * spring-oauth-server or myoidc-server  wellKnown json
     */
    private static JSONObject wellKnownJson;

    /**
     * spring-oauth-server or myoidc-server  wellKnown full url
     */
    private static String fullWellKnownUrl;

    /**
     * spring-oauth-server or myoidc-server  issuer
     */
    private static String issuer;


    public OAuth2Holder() {
    }


    public static String issuer() {
        return issuer;
    }

    public static String tokenUrl() {
        return tokenUrl;
    }

    public static String authorizeUrl() {
        return authorizeUrl;
    }

    public static String deviceAuthorizeUrl() {
        return deviceAuthorizeUrl;
    }

    public static String userinfoUrl() {
        return userinfoUrl;
    }

    public static String jwksUrl() {
        return jwksUrl;
    }

    public static String revokeUrl() {
        return revokeUrl;
    }

    public static String introspectUrl() {
        return introspectUrl;
    }

    public static JSONObject wellKnownJson() {
        return wellKnownJson;
    }

    public static String fullWellKnownUrl() {
        return fullWellKnownUrl;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(oauth2ServerHost, "oauth2.server.host is null");
        if (!oauth2ServerHost.endsWith("/")) {
            oauth2ServerHost += "/";
        }

        //请求 wellknown url
        fullWellKnownUrl = oauth2ServerHost + wellKnownUrl;
        if (LOG.isDebugEnabled()) {
            LOG.debug("Will request fullWellKnownUrl: {}", fullWellKnownUrl);
        }

        HttpClientExecutor clientExecutor = new HttpClientExecutor(fullWellKnownUrl)
                .maxConnectionSeconds(5);
        try {
            clientExecutor.executeWithException(response -> {
                String respText = response.responseAsString();
                if (!response.isResponse200()) {
                    if (LOG.isErrorEnabled()) {
                        LOG.error("WellKnownUrl: {} is not response 200, respText: {}, need checking", fullWellKnownUrl, respText);
                    }
                    setDefaultUrls();
                } else {
                    JSONObject json = JSONObject.fromObject(respText);
                    tokenUrl = json.getString("token_endpoint");
                    authorizeUrl = json.getString("authorization_endpoint");
                    deviceAuthorizeUrl = json.getString("device_authorization_endpoint");

                    jwksUrl = json.getString("jwks_uri");
                    revokeUrl = json.getString("revocation_endpoint");
                    introspectUrl = json.getString("introspection_endpoint");

                    userinfoUrl = json.getString("userinfo_endpoint");
                    issuer = json.getString("issuer");
                    wellKnownJson = json;
                }
            });
        } catch (Exception e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("WellKnownUrl: {} response", fullWellKnownUrl, e);
            }
            setDefaultUrls();
        }

        Assert.notNull(tokenUrl, "tokenUrl is null");
        Assert.notNull(authorizeUrl, "authorizeUrl is null");
        Assert.notNull(deviceAuthorizeUrl, "deviceAuthorizeUrl is null");

        Assert.notNull(jwksUrl, "jwksUrl is null");
        Assert.notNull(revokeUrl, "revokeUrl is null");
        Assert.notNull(introspectUrl, "introspectUrl is null");

        Assert.notNull(userinfoUrl, "userinfoUrl is null");

    }

    private void setDefaultUrls() {
        //use default
        tokenUrl = oauth2ServerHost + "oauth2/token";
        authorizeUrl = oauth2ServerHost + "oauth2/authorize";
        deviceAuthorizeUrl = oauth2ServerHost + "oauth2/device_authorization";

        jwksUrl = oauth2ServerHost + "oauth2/jwks";
        revokeUrl = oauth2ServerHost + "oauth2/revoke";
        introspectUrl = oauth2ServerHost + "oauth2/introspect";

        userinfoUrl = oauth2ServerHost + "userinfo";
        issuer = oauth2ServerHost;
    }
}
