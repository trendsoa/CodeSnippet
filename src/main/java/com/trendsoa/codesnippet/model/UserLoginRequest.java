package com.trendsoa.codesnippet.model;

import com.trendsoa.codesnippet.validator.AtLeastOne;
import com.trendsoa.codesnippet.validator.Mobile;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by jeszhang on 08-05-2017.
 */
@AtLeastOne(value = {"email", "mobile"}, message = "email or mobile is required")
public class UserLoginRequest {

    //    @NotBlank(message = "email can not be null")
    @Email(message = "must be email format")
    private String email;

    //    @NotNull(message = "mobile can not be null")
    @Mobile
//    @Pattern(regexp = "^1(3|5|7|8|4)\\d{9}$", message = "invalid mobile format")
    private String mobile;

    @NotNull(message = "password can not be null")
    @Length(min = 6, max = 16, message = "password length must be 6 ~ 16")
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
