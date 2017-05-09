package com.trendsoa.codesnippet.model;

import com.trendsoa.codesnippet.validator.group.GroupOne;
import com.trendsoa.codesnippet.validator.group.GroupTwo;

import javax.validation.constraints.NotNull;

/**
 * Created by jeszhang on 08-05-2017.
 */
public class UserRegistionRequest {
    @NotNull(groups = GroupOne.class, message = "name can not be null")
    private String name;
    @NotNull(groups = GroupOne.class, message = "nickname can not be null")
    private String nickname;
    @NotNull(groups = GroupTwo.class, message = "age can not be null")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserRegistionRequest{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }
}

