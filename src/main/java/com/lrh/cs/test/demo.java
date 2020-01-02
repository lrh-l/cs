package com.lrh.cs.test;

import com.alibaba.fastjson.JSONObject;
import com.lrh.cs.service.impl.UserserviceImpl;
import org.springframework.util.StringUtils;

import java.util.*;

public class demo {
    public static void main(String[] args) {
        String s = null;
        Integer s1 =1;

        System.out.println(s1 .equals(s));
        System.out.println("1".contains("1"));
        String str = "25,36,34";
        String st="active_ic_07_".concat("7");
        System.out.println(st);
        System.out.println("11111111111");
        System.out.println(Arrays.asList(str));
        boolean contains = Arrays.asList(str.split(",")).contains("5");
        System.out.println(contains);
        System.out.println(str.contains("5"));
        List<Map> list = new ArrayList<>();
        String string = "1-50,50-80,80-100";
        String[] split = string.split(",");
        for (int i=0; i<split.length;i++){
            Map map = new HashMap();
            map.put("min",split[i].substring(0,split[i].indexOf("-")));
            map.put("max",split[i].substring(split[i].indexOf("-")+1));
            list.add(map);
        }
        System.out.println(JSONObject.toJSON(list));

        String strings ="message-发";
        String sts = "12-5";
        Map map = new HashMap();
        for (int i=1;i<5;i++){
            map.put(i,strings);
            map.put(i+10,sts);
        }
        List list1 = Arrays.asList(map);
        System.out.println(JSONObject.toJSON(list1).toString());
        String MAX_BING_SHEN_CARD = "B05";
        String MIN_BING_SHEN_CARD = "B07";
        String MIN_BING_SHEN_CARDs= "bo5,B07";
        if ("bo5".equals(MAX_BING_SHEN_CARD) || "B0".equals(MIN_BING_SHEN_CARD)) {
            System.out.println("true");
        }else {
            System.out.println(11);
        }
        List<Map> demo = demo();
        System.out.println(JSONObject.toJSON(demo));
        demo.stream().filter(i-> i.get("user1").equals("张三1")).forEach(i-> {
            System.out.println(1111);
            test();
        });

        Map map1 = new HashMap();
        List list2 = new ArrayList();
        System.out.println(JSONObject.toJSON(demo)+"------------");
        for (Map map2:demo){
        map1.put("name",Arrays.asList(map2.get("userName"))+"=========");
        list2.add(map2.get("userName"));
        }

       System.out.println(JSONObject.toJSON(map1)+"+++++++++++++++++"+JSONObject.toJSON(list2));
    }

    private static Map testMap(){
        Map map = new HashMap();
        for (int i=1;i<5;i++){
            map.put("user"+i,"张三"+i);

        }
        return map;
    }

    private static void test(){
        System.out.println(22222);
        System.out.println(JSONObject.toJSON(demo()));
    }
    private static List<Map> demo(){
        List<Map> list = new ArrayList<>();
        Map map = new HashMap();
        for (int i=1;i<=3;i++){
            map.put("user"+i,"张三"+i);
            map.put("userName","李四"+i);

        }
        list.add(map);
      //  System.out.println(JSONObject.toJSON(list));
        return list;
    }

}
