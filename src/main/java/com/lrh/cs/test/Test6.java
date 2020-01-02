package com.lrh.cs.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test6 {
    public static boolean te(String s){
        System.out.println("+++++++++++");
        return s.equals(s);
    }
    public static void main(String[] args) {
        Map map = new HashMap();
        Map h = new HashMap();
        String s="1";
        String str ="w";
        String string ="23,23";
      /*  System.out.println(Arrays.asList(string.split("-")).contains("message"));
        System.out.println(JSONObject.toJSON(string.split("-")));*/
        if (!s.isEmpty() ||te(s)) {
            System.out.println(true);
        }else {
            System.out.println(false);
        }

        h.put("me","mess");
        Object message = map.put("message",s.isEmpty() ?str.isEmpty() ?"1":"2":string.isEmpty() ?"":"");
        System.out.println(JSONObject.toJSON(map));
        if (h.containsKey("message") || map.containsKey("message")) {
            System.out.println(true);
        }else {
            System.out.println(false);
        }


        System.out.println(Objects.isNull(message) ? "":"");
        System.out.println(!StringUtils.isEmpty((String)map.get("messsage")));
        System.out.println(map.containsValue("message"));
    }
}
