package com.andaily.springoauth.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.andaily.springoauth.infrastructure.OAuth2Holder.authorizeUrl;

/**
 * Handle 'implicit'  type actions
 *
 * @author Shengzhao Li
 * @deprecated OAuth2.1 not yet supported
 */
@Controller
public class ImplicitController {


    private static final Logger LOG = LoggerFactory.getLogger(ImplicitController.class);


//    @Value("#{properties['user-authorization-uri']}")
//    private String userAuthorizationUri;


//    @Value("#{properties['unityUserInfoUri']}")
//    private String unityUserInfoUri;

    @Value("${application-host:http://localhost:8082}")
    private String host;


    /**
   * Entrance:   step-1
   * */
    @RequestMapping(value = "implicit")
    public String password(Model model) {
        LOG.debug("Go to 'implicit' page, userAuthorizationUri = {}", authorizeUrl());
        model.addAttribute("userAuthorizationUri", authorizeUrl());
//        model.addAttribute("unityUserInfoUri", unityUserInfoUri);
        model.addAttribute("host", host);
        return "implicit";
    }


}