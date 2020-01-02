package com.lrh.cs.test;

import com.alibaba.fastjson.JSONObject;
import com.lrh.cs.pojo.Role;
import com.lrh.cs.pojo.User;
import com.mchange.v1.util.MapUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("www",123);
        Map demo = demo(map);
        if (!StringUtils.isEmpty(demo.get("message"))) {
            System.out.println(JSONObject.toJSON(map));
        }
        Map map1 = new HashMap();
        map1.put("","");
        System.out.println(map1.containsValue("")+"---");
        Map map2 = new HashMap();
        System.out.println(map2.size());
        map2.put("roleCode","zhangshan");
        map2.put("roleName","张三");
        Role user= parseMap2Object(map2, Role.class);
        System.out.println(user.getRoleName());
    }

    private static Map demo(Map map){
        map.put("message","错误");
        return map;
    }

    public static <T> T parseMap2Object(Map<String, Object> paramMap, Class<T> cls) {
        return JSONObject.parseObject(JSONObject.toJSONString(paramMap), cls);
    }

}
