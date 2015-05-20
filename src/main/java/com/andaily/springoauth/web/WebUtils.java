package com.andaily.springoauth.web;

import net.sf.json.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Shengzhao Li
 */
public abstract class WebUtils {


    public static final String STATE_SESSION_KEY = "state_key";

    public static final String AUTHORIZATION_CODE_DTO_SESSION_KEY = "AuthorizationCodeDto_key";


    private WebUtils() {
    }


    public static void writeJson(HttpServletResponse response, JSON json) {
        response.setContentType("application/json;charset=UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            json.write(writer);
            writer.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Write json to response error", e);
        }

    }

}