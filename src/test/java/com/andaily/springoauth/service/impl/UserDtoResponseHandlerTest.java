package com.andaily.springoauth.service.impl;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author Shengzhao Li
 */
public class UserDtoResponseHandlerTest {


    @Test
    public void testXML() {

        String text = "<oauth><error_description>Invalid access token: 3420d0e0-ed77-45e1-8370-2b55af0a62e8</error_description><error>invalid_token</error></oauth>";
        assertNotNull(text);

    }

}