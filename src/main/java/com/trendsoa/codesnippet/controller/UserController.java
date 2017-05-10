package com.trendsoa.codesnippet.controller;

import com.trendsoa.codesnippet.model.CopiedUserLoginRequest;
import com.trendsoa.codesnippet.model.User;
import com.trendsoa.codesnippet.model.UserLoginRequest;
import com.trendsoa.codesnippet.model.UserRegistionRequest;
import com.trendsoa.codesnippet.service.UserService;
import com.trendsoa.codesnippet.validator.group.GroupOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jeszhang on 08-05-2017.
 */
@RestController
@RequestMapping(value = "/user", produces = {"application/json"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@Validated @RequestBody UserLoginRequest userLoginRequest) {
        return new User("Tom", 20);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@Validated({GroupOne.class}) @RequestBody UserRegistionRequest userRegistionRequest) {
        return new User("Leon", 20);
    }

    @RequestMapping(value = "/spellogin", method = RequestMethod.POST)
    public User login(@Validated @RequestBody CopiedUserLoginRequest userLoginRequest) {

        userService.echo(userLoginRequest.getEmail(), userLoginRequest.getPassword());

        userService.getEchoString(userLoginRequest.getEmail());

        return new User("Depeux", 20);
    }

    @RequestMapping(value = "/getHeader", method = RequestMethod.GET)
    public String getHeader() {

//        HttpComponentsClientHttpRequestFactory
        //how to get request
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        return request.getHeader("test");
    }

}
