package com.lrh.cs.dao;

import com.lrh.cs.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
 User login(Map<String,Object> map) ;
 List<User> getUserList(Map<String,Object> map);

    List<User> getlikeNamePwdList( @Param("namePwd") String namePwd);
}
