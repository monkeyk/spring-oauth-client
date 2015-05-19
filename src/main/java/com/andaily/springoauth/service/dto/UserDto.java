package com.andaily.springoauth.service.dto;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * JSON data:
 * {"archived":false,"email":"unity@wdcy.cc","guid":"55b713df1c6f423e842ad68668523c49","phone":"","privileges":["UNITY"],"username":"unity"}
 *
 * @author Shengzhao Li
 */
public class UserDto implements Serializable {


    private boolean archived;
    private String email;
    private String guid;

    private String phone;
    private String username;

    private List<String> privileges = new ArrayList<>();


    //Error if have from oauth server
    private String errorDescription;
    private String error;


    public UserDto() {
    }

    public UserDto(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
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

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<String> privileges) {
        this.privileges = privileges;
    }
}