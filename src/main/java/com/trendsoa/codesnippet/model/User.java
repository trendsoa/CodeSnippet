package com.trendsoa.codesnippet.model;

/**
 * Created by jeszhang on 08-05-2017.
 */
public class User {

    private String nickName;
    private int age;

    public User(String nickName, int age) {
        this.nickName = nickName;
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
