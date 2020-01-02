package com.lrh.cs.test;

import com.alibaba.fastjson.JSONObject;
import com.lrh.cs.pojo.Role;
import com.lrh.cs.service.UserService;
import com.lrh.cs.service.impl.UserserviceImpl;

import javax.json.JsonObject;
import javax.xml.registry.infomodel.User;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test4 {

    public static void main(String[] args) {

        Thread t = new Thread(new Thread()) {
            @Override
            public void run() {
                System.out.println("no use lambda");
            }
        };

        Thread th = new Thread(() -> System.out.println("no"));

        List<Integer> integers = Arrays.asList(4, 5, 6, 1, 2, 3, 7, 8, 8, 9, 10);

        boolean b = integers.stream().allMatch(i -> i == 5);
        System.out.println(b);
        List<Integer> list = integers.stream().filter(i -> i % 2 == 0).limit(3).sorted().collect(Collectors.toList());
        System.out.println(list);

        List<Integer> squareList = integers.stream().map(i -> i * i).collect(Collectors.toList());//转成平方列表
        System.out.println(integers);
        System.out.println(squareList);

        List<Integer> collect = integers.stream().filter(i -> i % 2 == 0).map(i -> i * i).limit(2).sorted().collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> lists = integers.stream().filter(i -> i % 2 == 0).map(i -> i * i).distinct().collect(Collectors.toList());//复合操作
        System.out.println(list);
        List<Role> roleList = getRoleList();
        System.out.println(JSONObject.toJSON(roleList));
        List<Map> mapList = new ArrayList<>();
        Map map = new Hashtable();
        roleList.stream().forEach(i -> {
            System.out.println(i.getId());
            map.put(i.getId(),i.getRoleName());
            mapList.add(map);
        });
        System.out.println(JSONObject.toJSON(mapList) + "-------------------");

        roleList.stream().forEach(role -> System.out.println(role.getId() + role.getRoleName()));
      /*  try {
            Stream<String> stream = Files.lines(Paths.get("C:\\Users\\187101\\Desktop"),Charset.defaultCharset());
            System.out.println(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        boolean q = roleList.stream().anyMatch(i -> "李四1".equals(i.getRoleName()));
        System.out.println(q + "");
        List<Role> roleStream = roleList.stream().filter(i -> i.getId() == 1).collect(Collectors.toList());
        System.out.println(JSONObject.toJSON(roleList));

        List<Role> roleList1 = getRoleList();
        roleList1.stream().forEach(i -> {
            roleList.add(roleList.get(1));
            System.out.println(JSONObject.toJSON(i)+"******123***********");
        });
        System.out.println(roleList1.size());
        System.out.println("111111111111111");
        System.out.println("=========================");
        Map map1 = new HashMap();
        List<String> collect1 = roleList.stream().filter(role -> role.getRoleName().equals("李四1")).map(Role::getRoleName).collect(Collectors.toList());
        System.out.println(JSONObject.toJSON(collect.get(0))+"----------======");


        String incomeFlag = ("sc".equals("jh") ? "1" : "2");
        incomeFlag = ("jh".equals("jh") ? "4" : incomeFlag);
        System.out.println(incomeFlag);

        String sss = "00";
        System.out.println(sss.equals("js") || sss.equals("0"));
        Test5 ts = Test4::test;
        ts.test(5);
        int account = 5;
        Test5 test5 = a -> {
        };


        List<Map> roleListMap = getRoleListMap();

        Map map2 = new HashMap();
        map2.put("ff",23);
        demos(map2);

        System.out.println(JSONObject.toJSON(map2)+"--------");
        System.out.println("98".concat("qwer").substring(2));
        if (!"97".equals("98")) {
            System.out.println("111111");
        }else {
            System.out.println("222222222");
        }
    }

   static void demos(Map map){
        if (map.size()>0){
            map.put("u",12);
        }
       System.out.println("-------------");
        System.out.println(JSONObject.toJSON(map));
    }


    public  static boolean test(int a){
        return a>2;
    }
    public static List<Role> getRoleList(){
        List<Role> list= new ArrayList<>();
        for (int i=1;i<=5;i++){
            Role r = new Role();
            r.setId(i);
            r.setRoleName("李四"+i);
            list.add(r);
        }

        if (list.size()>2) {
            List<Role> listr = list.subList(0, 2);
            return listr;
        }

        return list;
    }

    public static List<Map> getRoleListMap(){
        List<Map> list= new ArrayList<>();
        Map map = new HashMap();
        for (int i=1;i<=5;i++){
            Role r = new Role();
            r.setId(i);
            r.setRoleName("李四"+i);
          map.put("user"+i,r);
        }


        return list;
    }


}
