package com.andaily.springoauth.web.controller;

import com.andaily.springoauth.service.OauthService;
import com.andaily.springoauth.service.dto.ClientDetailsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handle 'authorization_code' + PKCE type actions
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
@Controller
public class AuthorizationCodePkceController {


    private static final Logger LOG = LoggerFactory.getLogger(AuthorizationCodePkceController.class);


    @Value("${application-host:http://localhost:8082}")
    private String host;


    @Autowired
    private OauthService oauthService;


    /**
     * check pkce support
     */
    @GetMapping("authorization_code_pkce")
    public String authorizationCodePkce(Model model) {
        ClientDetailsDto clientDetailsDto = oauthService.loadClientDetails();

        if (clientDetailsDto.isSupportPkce()) {
            //与 authorization_code 流程一样
            return "redirect:authorization_code";
        } else {
            //error
            model.addAttribute("error", "PKCE is not supported");
            model.addAttribute("message", "ClientId: " + clientDetailsDto.getClientId() + " not supported PKCE");
            return "oauth_error";
        }
    }


}