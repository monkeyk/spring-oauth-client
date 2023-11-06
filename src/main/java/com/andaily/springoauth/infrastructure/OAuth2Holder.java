package com.andaily.springoauth.infrastructure;

import com.andaily.springoauth.infrastructure.httpclient.HttpClientExecutor;
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
     * spring-oauth-server or myoidc-server userinfo url:  /userinfo
     */
    private static String userinfoUrl;


    public OAuth2Holder() {
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(oauth2ServerHost, "oauth2.server.host is null");
        if (!oauth2ServerHost.endsWith("/")) {
            oauth2ServerHost += "/";
        }

        //请求 wellknown url
        String fullWellKnownUrl = oauth2ServerHost + wellKnownUrl;
        if (LOG.isDebugEnabled()) {
            LOG.debug("Will request fullWellKnownUrl: {}", fullWellKnownUrl);
        }

        HttpClientExecutor clientExecutor = new HttpClientExecutor(fullWellKnownUrl);
        clientExecutor.execute(response -> {
            String respText = response.responseAsString();
            if (!response.isResponse200()) {
                if (LOG.isErrorEnabled()) {
                    LOG.error("WellKnownUrl: {} is not response 200, respText: {}, need checking", fullWellKnownUrl, respText);
                }
            } else {
//                tokenUrl = response.getFirstHeader("token_endpoint").getValue();
//                authorizeUrl = response.getFirstHeader("authorization_endpoint").getValue();
//                userinfoUrl = response.getFirstHeader("userinfo_endpoint").getValue();
            }
        });

    }
}
