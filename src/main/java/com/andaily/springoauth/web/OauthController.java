package com.andaily.springoauth.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

/**
 * @author Shengzhao Li
 */

@Controller
public class OauthController {


    @Value("#{properties['user-authorization-uri']}")
    private String userAuthorizationUri;

    @Value("#{properties['application-host']}")
    private String host;


    @RequestMapping(value = "authorization_code", method = RequestMethod.GET)
    public String authorizationCode(Model model) {
        model.addAttribute("userAuthorizationUri", userAuthorizationUri);
        model.addAttribute("host", host);
        model.addAttribute("state", UUID.randomUUID().toString());
        return "authorization_code";
    }


}