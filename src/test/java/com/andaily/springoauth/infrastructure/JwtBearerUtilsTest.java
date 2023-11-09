package com.andaily.springoauth.infrastructure;

import com.nimbusds.jose.jwk.JWK;
import org.junit.jupiter.api.Test;

import static com.andaily.springoauth.web.controller.JwtBearerJwksController.ES256_KEY;
import static com.andaily.springoauth.web.controller.JwtBearerJwksController.RS256_KEY;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 2023/11/9 15:54
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
class JwtBearerUtilsTest {

    /**
     * client id
     */
    private final String clientId = "vLIXDF9GXg6Psfh1uzwVFUj0fucX2Zn9";

    /**
     * auth-server  地址
     */
    private final String audience = "http://127.0.0.1:8080";


    @Test
    void generateRsAssertion() throws Exception {

        JWK rsJwk = JWK.parse(RS256_KEY);

        String assertion = JwtBearerUtils.generateRsAssertion(clientId, audience, rsJwk);
        assertNotNull(assertion);
    }

    @Test
    void generateEsAssertion() throws Exception {

        JWK esJwk = JWK.parse(ES256_KEY);

        String assertion = JwtBearerUtils.generateEsAssertion(clientId, audience, esJwk);
        assertNotNull(assertion);
    }

    @Test
    void generateMacAssertion() throws Exception {


        // client_secret 加密后的值, 从 spring-oauth-server 数据库中查询获取
        String macSecret = "$2a$10$kjjdfA8SIuhlVx0q4B1GYeU..9TNU9.Aj6Vdc2v/iQTJhhmT/0xCi";

        String assertion = JwtBearerUtils.generateMacAssertion(clientId, audience, macSecret);
        assertNotNull(assertion);
    }
}