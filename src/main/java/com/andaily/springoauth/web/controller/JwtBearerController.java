package com.andaily.springoauth.web.controller;

import com.andaily.springoauth.infrastructure.OAuth2Holder;
import com.andaily.springoauth.service.OauthService;
import com.andaily.springoauth.service.dto.AuthDeviceCodeDto;
import com.andaily.springoauth.service.dto.ClientDetailsDto;
import com.andaily.springoauth.service.dto.DeviceAuthorizationDto;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.andaily.springoauth.web.WebUtils.writeJson;

/**
 * 2023/11/9 15:30
 * <p>
 * Handle 'jwt-bearer'  type actions
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
@Controller
public class JwtBearerController {


    private static final Logger LOG = LoggerFactory.getLogger(JwtBearerController.class);


    @Value("${application-host:http://localhost:8082}")
    private String host;


    @Autowired
    private OauthService oauthService;


    /**
     * Entrance:   step-1
     */
    @GetMapping("jwt_bearer")
    public String jwtBearer(Model model) {
        ClientDetailsDto clientDetailsDto = oauthService.loadClientDetails();
        model.addAttribute("clientDetails", clientDetailsDto);

        String host2 = host.endsWith("/") ? host : host + "/";
        model.addAttribute("host", host2);
        model.addAttribute("tokenUrl", OAuth2Holder.tokenUrl());
        // see JwtBearerJwksController.java
        model.addAttribute("jwkUrl", host2 + "api/public/oauth2/jwt_bearer/demo_jwks");

        return "jwt_bearer";
    }


}
