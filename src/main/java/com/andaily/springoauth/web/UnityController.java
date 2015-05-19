package com.andaily.springoauth.web;

import com.andaily.springoauth.service.ResourceService;
import com.andaily.springoauth.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Local resource actions.
 * No relation with Oauth
 *
 * @author Shengzhao Li
 */
@Controller
@RequestMapping("/unity/")
public class UnityController {


    @Autowired
    private ResourceService resourceService;


    @RequestMapping("overview")
    public String overview(Model model) {
        UserDto userDto = resourceService.loadUnityUserDto();
        model.addAttribute("userDto", userDto);
        return "unity_overview";
    }

}