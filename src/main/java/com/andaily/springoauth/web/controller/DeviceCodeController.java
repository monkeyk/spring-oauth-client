package com.andaily.springoauth.web.controller;

import com.andaily.springoauth.infrastructure.OAuth2Holder;
import com.andaily.springoauth.service.OauthService;
import com.andaily.springoauth.service.dto.*;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.andaily.springoauth.web.WebUtils.writeJson;

/**
 * 2023/11/8 20:30
 * <p>
 * Handle 'device_code'  type actions
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
@Controller
public class DeviceCodeController {


    private static final Logger LOG = LoggerFactory.getLogger(DeviceCodeController.class);


    @Value("${application-host:http://localhost:8082}")
    private String host;


    @Autowired
    private OauthService oauthService;


    /**
     * Entrance:   step-1
     */
    @GetMapping("device_code")
    public String deviceCode(Model model) {
        ClientDetailsDto clientDetailsDto = oauthService.loadClientDetails();
        model.addAttribute("clientDetails", clientDetailsDto);

        String host2 = host.endsWith("/") ? host : host + "/";
        model.addAttribute("host", host2);
        model.addAttribute("deviceAuthorizeUrl", OAuth2Holder.deviceAuthorizeUrl());
        return "device_code";
    }


    /**
     * Ajax call , get user_code, device_code, verification_uri
     */
    @PostMapping("device_code")
    public void getDeviceCode(@RequestBody AuthDeviceCodeDto deviceCodeDto, HttpServletResponse response) {
        DeviceAuthorizationDto authDeviceCodeDto = oauthService.retrieveDeviceAuthorizationDto(deviceCodeDto);
        writeJson(response, JSONObject.fromObject(authDeviceCodeDto));
    }

}
