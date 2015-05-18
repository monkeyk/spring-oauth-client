package com.andaily.springoauth.service.dto;

/**
 * @author Shengzhao Li
 */
public class AuthCallbackDto {


    private String code;
    private String state;


    public AuthCallbackDto() {
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}