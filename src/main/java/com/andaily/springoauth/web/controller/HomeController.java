package com.andaily.springoauth.web.controller;

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


    /**
     * 首页
     *
     * @return view
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("fullWellKnownUrl", fullWellKnownUrl());
        return "index";
    }

}
