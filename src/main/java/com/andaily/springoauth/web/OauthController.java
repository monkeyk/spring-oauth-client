package com.andaily.springoauth.web;

import com.andaily.springoauth.service.dto.AuthAccessTokenDto;
import com.andaily.springoauth.service.dto.AuthCallbackDto;
import com.andaily.springoauth.service.dto.AuthorizationCodeDto;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author Shengzhao Li
 */

@Controller
public class OauthController {

    private static final Logger LOG = LoggerFactory.getLogger(OauthController.class);


    @Value("#{properties['user-authorization-uri']}")
    private String userAuthorizationUri;

    @Value("#{properties['access-token-uri']}")
    private String accessTokenUri;


    @Value("#{properties['application-host']}")
    private String host;


    @RequestMapping(value = "authorization_code", method = RequestMethod.GET)
    public String authorizationCode(Model model) {
        model.addAttribute("userAuthorizationUri", userAuthorizationUri);
        model.addAttribute("host", host);
        model.addAttribute("state", UUID.randomUUID().toString());
        return "authorization_code";
    }


    @RequestMapping(value = "authorization_code", method = RequestMethod.POST)
    public String submitAuthorizationCode(AuthorizationCodeDto codeDto, HttpServletRequest request) throws Exception {
        final String fullUri = codeDto.getFullUri();
        LOG.debug("Send to Oauth-Server URL: {}", fullUri);

        return "redirect:" + fullUri;
    }


    // authorization_code_callback
    @RequestMapping(value = "authorization_code_callback")
    public String authorizationCodeCallback(AuthCallbackDto callbackDto, Model model, HttpServletRequest request) throws Exception {

        if (callbackDto.error()) {
            //Server response error
            model.addAttribute("message", callbackDto.getError_description());
            model.addAttribute("error", callbackDto.getError());
            return "redirect:oauth_error";
        } else if (correctState(request, callbackDto)) {
            //Go to retrieve access_token form
            AuthAccessTokenDto accessTokenDto = createAuthAccessTokenDto(callbackDto, request);
            model.addAttribute("accessTokenDto", accessTokenDto);
            model.addAttribute("host", host);
            return "code_access_token";
        } else {
            //illegal state
            model.addAttribute("message", "Illegal \"state\": " + callbackDto.getState());
            model.addAttribute("error", "Invalid state");
            return "redirect:oauth_error";
        }

    }

    private AuthAccessTokenDto createAuthAccessTokenDto(AuthCallbackDto callbackDto, HttpServletRequest request) {
        return new AuthAccessTokenDto()
                .setAccessTokenUri(accessTokenUri)
                .setCode(callbackDto.getCode());
    }

    private boolean correctState(HttpServletRequest request, AuthCallbackDto callbackDto) {
        final String state = callbackDto.getState();
        return StringUtils.isNotEmpty(state);
    }


    @RequestMapping(value = "code_access_token", method = RequestMethod.POST)
    public String codeAccessToken(AuthAccessTokenDto tokenDto, HttpServletRequest request) throws Exception {
        final String fullUri = tokenDto.getFullUri();
        LOG.debug("Get access_token URL: {}", fullUri);

        return "redirect:" + fullUri;
    }


    /*
   * Common handle oauth error ,
   * show the error message.
   * */
    @RequestMapping("oauth_error")
    public String oauthError(String error, String message, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("message", message);
        return "oauth_error";
    }

}