package com.andaily.springoauth.service.impl;

import com.andaily.springoauth.service.ResourceService;
import com.andaily.springoauth.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;

/**
 * @author Shengzhao Li
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {


    @Autowired
    private OAuth2RestTemplate unityRestTemplate;


    @Value(value = "${unityUserInfoUri}")
    private String unityUserInfoUri;


    @Override
    public UserDto loadUnityUserDto() {
        final UserDto userDto = unityRestTemplate.getForObject(URI.create(unityUserInfoUri), UserDto.class);
        return userDto;
    }
}