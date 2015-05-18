package com.andaily.springoauth.web;

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

import static com.andaily.springoauth.web.WebUtils.STATE_SESSION_KEY;

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

        request.getSession().setAttribute(STATE_SESSION_KEY, codeDto.getState());
        return "redirect:" + fullUri;
    }

    // authorization_code_callback
    @RequestMapping(value = "authorization_code_callback", method = RequestMethod.POST)
    public String authorizationCodeCallback(AuthCallbackDto callbackDto, Model model, HttpServletRequest request) throws Exception {

        final String currState = (String) request.getSession().getAttribute(STATE_SESSION_KEY);
        final String state = callbackDto.getState();

        if (StringUtils.isNotEmpty(state) && state.equals(currState)) {
            //retrieve access_token


        } else {
            //illegal state
            model.addAttribute("message", "Illegal 'state': " + state);
            return "redirect:oauth_error";
        }


        return "redirect:";
    }


}