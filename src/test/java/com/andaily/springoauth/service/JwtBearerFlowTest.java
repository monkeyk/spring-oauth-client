package com.andaily.springoauth.service;

import com.andaily.springoauth.infrastructure.JwtBearerUtils;
import com.nimbusds.jose.jwk.JWK;
import org.junit.jupiter.api.Test;

import static com.andaily.springoauth.web.controller.JwtBearerJwksController.ES256_KEY;
import static com.andaily.springoauth.web.controller.JwtBearerJwksController.RS256_KEY;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 2023/11/08 10:25
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
public class JwtBearerFlowTest {


    /**
     * RSA 生成 assertion
     * SignatureAlgorithm:  RS256
     * method:  PRIVATE_KEY_JWT
     *
     * @throws Exception e
     */
    @Test
    void rs256Assertion() throws Exception {

        JWK rsJwk = JWK.parse(RS256_KEY);

        String clientId = "dofOx6hjxlWw9qe2bnFvqbiPhuWwGWdn";
        String aud = "http://127.0.0.1:8080";


        // 将 assertion 复制放到请求参数  client_assertion 的值
        String assertion = JwtBearerUtils.generateRsAssertion(clientId, aud, rsJwk);
        assertNotNull(assertion);
//        System.out.println(assertion);

    }

    /**
     * ES 生成 assertion
     * SignatureAlgorithm:  ES256
     * method:  PRIVATE_KEY_JWT
     *
     * @throws Exception e
     */
    @Test
    void es256Assertion() throws Exception {

        JWK rsJwk = JWK.parse(ES256_KEY);

        String clientId = "pRC9j1mwGNMuchoI8nwJ6blr1lmPBLha";
        String aud = "http://127.0.0.1:8080";

        // 将 assertion 复制放到请求参数  client_assertion 的值
        String assertion = JwtBearerUtils.generateEsAssertion(clientId, aud, rsJwk);
        assertNotNull(assertion);
//        System.out.println(assertion);

    }


    /**
     * MAC 生成 assertion
     * HS256
     * method:  CLIENT_SECRET_JWT
     * <p>
     * TODO: 不推荐使用
     *
     * @throws Exception e
     */
    @Test
    void macAssertion() throws Exception {

        String clientId = "vLIXDF9GXg6Psfh1uzwVFUj0fucX2Zn9";
        String aud = "http://127.0.0.1:8080";

        // client_secret 加密后的值, 从 spring-oauth-server 数据库中查询获取
        String macSecret = "$2a$10$kjjdfA8SIuhlVx0q4B1GYeU..9TNU9.Aj6Vdc2v/iQTJhhmT/0xCi";


        // 将 assertion 复制放到请求参数  client_assertion 的值
        String assertion = JwtBearerUtils.generateMacAssertion(clientId, aud, macSecret);
        assertNotNull(assertion);
//        System.out.println(assertion);

    }

}
