package com.andaily.springoauth.web.controller;

import com.andaily.springoauth.service.OauthService;
import com.andaily.springoauth.service.dto.ClientDetailsDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.andaily.springoauth.infrastructure.OAuth2Holder.fullWellKnownUrl;

/**
 * 2023/11/7 11:13
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
@Controller
public class HomeController {


    @Autowired
    private OauthService oauthService;


    @Value("${application-host:http://localhost:8082}")
    private String host;


    /**
     * 首页
     *
     * @return view
     */
    @GetMapping("/")
    public String index(Model model) {
        ClientDetailsDto clientDetailsDto = oauthService.loadClientDetails();

        String host2 = host.endsWith("/") ? host : host + "/";
        model.addAttribute("host", host2);
        String redirectUri = host2 + "authorization_code_callback";
        model.addAttribute("redirectUri", redirectUri);
        //初始化
        if (StringUtils.isBlank(clientDetailsDto.getRedirectUris())) {
            clientDetailsDto.setRedirectUris(redirectUri);
        }
        model.addAttribute("clientDetails", clientDetailsDto);
        model.addAttribute("fullWellKnownUrl", fullWellKnownUrl());


        return "index";
    }

}
