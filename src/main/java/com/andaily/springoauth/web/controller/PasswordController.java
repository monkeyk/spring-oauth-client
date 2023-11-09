package com.andaily.springoauth.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.andaily.springoauth.infrastructure.OAuth2Holder.tokenUrl;

/**
 * Handle 'password'  type actions
 *
 * @author Shengzhao Li
 * @deprecated OAuth2.1 not yet supported
 */
@Controller
public class PasswordController {


    private static final Logger LOG = LoggerFactory.getLogger(PasswordController.class);


//    @Value("#{properties['access-token-uri']}")
//    private String accessTokenUri;


    /**
     * Entrance:   step-1
     */
    @RequestMapping(value = "password", method = RequestMethod.GET)
    public String password(Model model) {
        LOG.debug("Go to 'password' page, accessTokenUri = {}", tokenUrl());
        model.addAttribute("accessTokenUri", tokenUrl());
        return "password";
    }


}