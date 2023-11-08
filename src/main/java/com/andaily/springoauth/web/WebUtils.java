package com.andaily.springoauth.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;


import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Shengzhao Li
 */
public abstract class WebUtils {

    /**
     * session key for code_Verifier
     *
     * @since 2.0.0
     */
    private static final String CODE_VERIFIER_KEY = "code_Verifier";

    private WebUtils() {
    }


    /**
     * Save state to ServletContext, key = value = state
     */
    public static void saveState(HttpServletRequest request, String state) {
        final ServletContext servletContext = request.getSession().getServletContext();
        servletContext.setAttribute(state, state);
    }

    /**
     * Validate state when callback from Oauth Server.
     * If validation successful, will remove it from ServletContext.
     */
    public static boolean validateState(HttpServletRequest request, String state) {
        if (StringUtils.isEmpty(state)) {
            return false;
        }
        final ServletContext servletContext = request.getSession().getServletContext();
        final Object value = servletContext.getAttribute(state);

        if (value != null) {
            servletContext.removeAttribute(state);
            return true;
        }
        return false;
    }


    public static void writeJson(HttpServletResponse response, JSON json) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try {
            PrintWriter writer = response.getWriter();
            json.write(writer);
            writer.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Write json to response error", e);
        }

    }

    /**
     * Save code_verifier to session, key = value = code_verifier
     *
     * @since 2.0.0
     */

    public static void saveCodeVerifier(HttpServletRequest request, String codeVerifier) {
        request.getSession().setAttribute(CODE_VERIFIER_KEY, codeVerifier);
    }

    /**
     * Get code_verifier from session
     *
     * @since 2.0.0
     */
    public static String getCodeVerifier(HttpServletRequest request) {
        return (String) request.getSession().getAttribute(CODE_VERIFIER_KEY);
    }

}