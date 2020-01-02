package com.lrh.cs.test;


import com.alibaba.fastjson.JSONObject;
import com.lrh.cs.pojo.Role;

import javax.servlet.http.HttpServlet;
import javax.swing.text.Style;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntToDoubleFunction;

public class Test2  {

    public static List<Map<String,List<Role>>> getRole(){
        System.out.println("---------------------------");
        long l = System.currentTimeMillis();
        System.out.println( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(l)));
        List<Map<String,List<Role>>> list = new ArrayList<>();
        Map<String ,List<Role>> map = new HashMap<>();
        List<Role> roleList = new ArrayList<>();
        for (int i=0;i<4;i++){
            Role role = new Role();
            role.setId(i);
            role.setRoleName("张三"+i);
            roleList.add(role);
            map.put("r"+i,roleList);
            list.add(map);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        return list;
    }
    public static void main(String[] args) {
       // List<Map<String, List<Role>>> role = getRole();
        Map<String,List<Role>> map = new HashMap<>();
        List<Role> list = new ArrayList<>();
        for (int i=1;i<4;i++){
            Role r = new Role();
            r.setId(i);
            r.setRoleName("张三"+i);
            list.add(r);
            map.put("r"+i,list);
        }

        IntBinaryOperator intBinaryOperator = (int a, int b) -> {
            return a + b;
        };
        int i = intBinaryOperator.applyAsInt(1, 2);
        System.out.println(i);
        JSONObject jsonObject = new JSONObject();

        List<Map<String, List<Role>>> role = getRole();
        System.out.println(JSONObject.toJSON(role));
        Map<String, List<Role>> map1 = role.get(1);
        System.out.println("==================");
        System.out.println(JSONObject.toJSON(map1));
        List<Role> list1 = map.get("1");
        Role role1 = list.get(1);
        System.out.println(role1.getRoleName());


        System.out.println(System.currentTimeMillis());
    }


    public static String longToDate(long lo){

        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);

    }
}
