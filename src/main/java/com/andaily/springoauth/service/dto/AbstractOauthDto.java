package com.andaily.springoauth.service.dto;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * @author Shengzhao Li
 */
public abstract class AbstractOauthDto implements Serializable {


    //Error if have from oauth server
    protected String errorDescription;
    protected String error;

    protected AbstractOauthDto() {
    }


    public boolean error() {
        return StringUtils.isNotEmpty(error) || StringUtils.isNotEmpty(errorDescription);
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}