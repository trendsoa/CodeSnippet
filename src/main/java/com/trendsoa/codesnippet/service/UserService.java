package com.trendsoa.codesnippet.service;

import com.trendsoa.codesnippet.validator.SpELValidateMethodArgs;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Created by jeszhang on 09-05-2017.
 */
@Service
@Validated
public class UserService {

    @SpELValidateMethodArgs(value = "#arg0 != null && #arg1 != null", message = "s1 and s2 must not be null")
    public void echo(String s1, String s2) {
        System.out.println(s1 + s2);
    }

    public String getEchoString(@NotNull(message = "echo.key not null") String key) {
        return key + "value";
    }

}
