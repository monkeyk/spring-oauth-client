package com.andaily.springoauth.infrastructure;

import com.andaily.springoauth.ContextTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 2023/11/7 10:40
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
class OAuth2HolderTest extends ContextTest {


    @Test
    @Disabled
    void properties() {

        assertEquals("http://localhost:8080/oauth2/token", OAuth2Holder.tokenUrl());


    }

}