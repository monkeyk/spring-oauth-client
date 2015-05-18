package com.andaily.springoauth.service.impl;

import com.andaily.springoauth.service.ResourceService;
import com.andaily.springoauth.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Shengzhao Li
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {


    @Value(value = "${unityUserInfoUri}")
    private String unityUserInfoUri;


    @Override
    public UserDto loadUnityUserDto() {
        throw new UnsupportedOperationException("Not yet implements");
    }
}