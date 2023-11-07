package com.andaily.springoauth.web.controller;

import com.andaily.springoauth.service.OauthService;
import com.andaily.springoauth.service.dto.ClientDetailsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handle commons oauth actions
 *
 * @author Shengzhao Li
 */

@Controller
public class OauthController {

    private static final Logger LOG = LoggerFactory.getLogger(OauthController.class);


    @Autowired
    private OauthService oauthService;


    /**
     * 保存 client_details
     *
     * @since 2.0.0
     */
    @PostMapping("client_details")
    public String saveClientDetails(@Validated ClientDetailsDto clientDetailsDto, BindingResult result) {
        if (result.hasErrors()) {
            if (LOG.isWarnEnabled()) {
                LOG.warn("Save ClientDetailsDto errors: {}, need checking", result.getAllErrors());
            }
            return "redirect:/";
        }
        oauthService.saveClientDetails(clientDetailsDto);
        return "redirect:/";
    }


    /**
     * Common handle oauth error ,
     * show the error message.
     */
    @RequestMapping("oauth_error")
    public String oauthError(String error, String message, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("message", message);

        LOG.debug("Go to oauth_error, error={},message={}", error, message);
        return "oauth_error";
    }

}