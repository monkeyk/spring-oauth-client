package com.andaily.springoauth.infrastructure;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jwt.JWTClaimsSet;

import java.time.Instant;
import java.util.Date;

/**
 * 2023/11/9 15:41
 * <p>
 * jwt-bearer utils
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
public abstract class JwtBearerUtils {


    private JwtBearerUtils() {
    }


    /**
     * RS256  assertion 生成
     *
     * @param clientId clientId
     * @param audience 一般是授权服务器的url,  如: http://auth.server.com:8080
     * @param jwk      JWK 根据  jwks 中配置的, 必须是 RSA算法
     */
    public static String generateRsAssertion(String clientId, String audience, JWK jwk) throws JOSEException {

        JWSSigner jwsSigner = new RSASSASigner(jwk.toRSAKey());
        JWSHeader header = new JWSHeader(JWSAlgorithm.RS256);

        return generateAssertion(clientId, audience, jwsSigner, header);
    }

    /**
     * ES256 assertion 生成
     *
     * @param clientId clientId
     * @param audience 一般是授权服务器的url,  如: http://auth.server.com:8080
     * @param jwk      JWK 根据  jwks 中配置的, 必须是 ES算法
     */
    public static String generateEsAssertion(String clientId, String audience, JWK jwk) throws JOSEException {

        JWSSigner jwsSigner = new ECDSASigner(jwk.toECKey());
        JWSHeader header = new JWSHeader(JWSAlgorithm.ES256);

        return generateAssertion(clientId, audience, jwsSigner, header);
    }

    /**
     * MAC assertion 生成
     * 对称算法，不推荐
     *
     * @param clientId  clientId
     * @param audience  一般是授权服务器的url,  如: http://auth.server.com:8080
     * @param macSecret Mac 加密 secret
     */
    public static String generateMacAssertion(String clientId, String audience, String macSecret) throws JOSEException {

        JWSSigner jwsSigner = new MACSigner(macSecret);
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);

        return generateAssertion(clientId, audience, jwsSigner, header);
    }


    /**
     * 具体生成  assertion
     *
     * @return assertion
     * @throws JOSEException e
     */
    private static String generateAssertion(String clientId, String audience, JWSSigner jwsSigner, JWSHeader header) throws JOSEException {
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(clientId)
                .issuer(clientId)
                .audience(audience)
                // assertion有效时间, 5分钟
                .expirationTime(Date.from(Instant.now().plusSeconds(300L)))
                .build();
        Payload payload = new Payload(claimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);
        //签名
        jwsObject.sign(jwsSigner);
        return jwsObject.serialize();
    }


}
