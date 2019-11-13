package com.lrh.cs.service;

import com.lrh.cs.pojo.User;

import java.util.List;

public interface UserService {
    User login(String userCode,String userPassword);
    List<User> getUserList(String name,int role,int start,int end);
    void getdemo();
    List<User> getBylikeNameList( String namePwd);
}
