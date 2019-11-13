package com.lrh.cs.test;

import com.alibaba.fastjson.JSON;
import com.lrh.cs.dao.CodeDao;
import com.lrh.cs.dao.UserDao;
import com.lrh.cs.pojo.Code;
import com.lrh.cs.pojo.User;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class Test {
    @Resource
    UserDao userDao;
    @Resource
    CodeDao codeDao;
    @org.junit.Test
    public void loginTest(){
        List<Code> codes = codeDao.queryList();
            if (codes.size()>0 && codes!=null) {
                for (Code code : codes) {
                    List<Code> code1 = getCode(code);
                    for (Code code2 : code1) {
                        System.out.println(code2.getTitle());
                    }
                }
            List<Code> codeList = new ArrayList<>();
        }
    }
    public List<Code>getCode(Code code){
        List<Code> codeList = codeDao.code2(code.getDirid());
        if (codeList.size()>0 && codeList!=null){
            for (Code code1 :codeList){
               if (code1!=null && codeList.size()>0){
                   System.out.println(code1.getTitle());
               }
            }
        }

        return codeList;
    }

    public static void main(String[] args) {
     List<Code> list = new ArrayList<>();
     for (int i=0;i<2 ;i++){
         Code user = new Code();
            user.setTitle("jiangxi");
            user.setId(i);
            list.add(user);
     }
      String str = JSON.toJSONString(list);
        System.out.println(str);

    }
    public static boolean isMobile(final String str) {
        Pattern p = null;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        return p.matcher(str).matches();
    }

}
