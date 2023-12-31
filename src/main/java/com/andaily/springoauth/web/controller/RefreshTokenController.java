package com.andaily.springoauth.web.controller;

import com.andaily.springoauth.service.OauthService;
import com.andaily.springoauth.service.dto.AccessTokenDto;
import com.andaily.springoauth.service.dto.AuthAccessTokenDto;
import com.andaily.springoauth.service.dto.ClientDetailsDto;
import com.andaily.springoauth.service.dto.RefreshAccessTokenDto;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.andaily.springoauth.infrastructure.OAuth2Holder.tokenUrl;
import static com.andaily.springoauth.web.WebUtils.writeJson;

/**
 * Handle 'refresh_token'  type actions
 *
 * @author Shengzhao Li
 */
@Controller
public class RefreshTokenController {


    private static final Logger LOG = LoggerFactory.getLogger(RefreshTokenController.class);


    @Autowired
    private OauthService oauthService;


//    @Value("#{properties['access-token-uri']}")
//    private String accessTokenUri;


    /**
   * Entrance:   step-1
   * */
    @RequestMapping(value = "refresh_token", method = RequestMethod.GET)
    public String password(Model model) {
        LOG.debug("Go to 'refresh_token' page, accessTokenUri = {}", tokenUrl());

        ClientDetailsDto clientDetailsDto = oauthService.loadClientDetails();
        model.addAttribute("clientDetails", clientDetailsDto);
        model.addAttribute("accessTokenUri", tokenUrl());
        return "refresh_token";
    }

    /**
    * Ajax call , get access_token
     *
     * @deprecated OAuth2.1中不再支持 password
    * */
    @RequestMapping(value = "password_access_token")
    public void getAccessToken(AuthAccessTokenDto authAccessTokenDto, HttpServletResponse response) {
        AccessTokenDto accessTokenDto = oauthService.retrievePasswordAccessTokenDto(authAccessTokenDto);
        writeJson(response, JSONObject.fromObject(accessTokenDto));
    }

    /**
    * Ajax call , refresh access_token
    * */
    @RequestMapping(value = "refresh_access_token")
    public void refreshAccessToken(RefreshAccessTokenDto refreshAccessTokenDto, HttpServletResponse response) {
        AccessTokenDto accessTokenDto = oauthService.refreshAccessTokenDto(refreshAccessTokenDto);
        writeJson(response, JSONObject.fromObject(accessTokenDto));
    }


}