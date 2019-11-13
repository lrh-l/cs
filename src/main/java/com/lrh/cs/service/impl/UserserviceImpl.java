package com.lrh.cs.service.impl;

import com.lrh.cs.dao.UserDao;
import com.lrh.cs.pojo.User;
import com.lrh.cs.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserserviceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Override
    public User login(String userCode,String userPassword) {
        Map<String,Object> map = new HashMap<>();
        map.put("userCode",userCode);
        map.put("userPassword",userPassword);
        return userDao.login(map);
    }

    @Override
    public List<User> getUserList(String name, int role, int start, int end) {
        Map<String,Object> map = new HashMap<>();
        map.put("userName",name);
        map.put("userRole",role);
        map.put("currentPageNo",start);
        map.put("pageSize",end);
        List<User> userList = userDao.getUserList(map);
        return userList;
    }

    @Override
    public void getdemo() {

    }

    @Override
    public List<User> getBylikeNameList(String namePwd) {

        return userDao.getlikeNamePwdList(namePwd);
    }

}
