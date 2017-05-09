package com.trendsoa.codesnippet.model;

import com.trendsoa.codesnippet.validator.SpELValidateClass;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by jeszhang on 08-05-2017.
 */
@SpELValidateClass(value = "!(#this.email == null && #this.mobile == null)", message = "email or mobile must be defined")
@SpELValidateClass(value = "#this.password.length() >=6 && #this.password.length() <= 16", message = "password length must be 6 ~ 16")
public class CopiedUserLoginRequest {

    @Email(message = "must be email format")
    private String email;

    @Pattern(regexp = "^1(3|5|7|8|4)\\d{9}$", message = "invalid mobile format")
    private String mobile;

    @NotNull(message = "password can not be null")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginRequest{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
