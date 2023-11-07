package com.andaily.springoauth.service.dto;

import java.io.Serial;
import java.io.Serializable;

/**
 * 2023/11/7 12:07
 * <p>
 * {
 * "sub": "admin",
 * "updated_at": "123456990",
 * "nickname": "xxx"
 * }
 * <p>
 * 响应的数据信息可由 server端调整后在此添加或修改
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
public class UserinfoDto  extends AbstractOauthDto {
    @Serial
    private static final long serialVersionUID = -8952118310258988557L;

    private String sub;

    private String nickname;

    private long updated_at;

    private String phone;

    private String email;

    private String address;

    public UserinfoDto() {
    }

    public UserinfoDto(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
    }


    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
