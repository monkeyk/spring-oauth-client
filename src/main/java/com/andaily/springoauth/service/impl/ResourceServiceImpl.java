package com.andaily.springoauth.service.impl;

import com.andaily.springoauth.service.ResourceService;
import com.andaily.springoauth.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Shengzhao Li
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {


    @Value(value = "${unityUserInfoUri}")
    private String unityUserInfoUri;


    @Override
    public UserDto loadUnityUserDto() {
        final User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto userDto = new UserDto();

        userDto.setUsername(principal.getUsername());
        final Collection<GrantedAuthority> authorities = principal.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            userDto.getPrivileges().add(authority.getAuthority());
        }

        return userDto;
    }
}