package com.lrh.cs.controller;

import com.lrh.cs.pojo.User;
import com.lrh.cs.service.UserService;
import com.lrh.cs.utils.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static  final Logger looger = Logger.getLogger(UserController.class);

    @Resource
    UserService userService;
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
     public String login() {
        looger.debug("-----------------进入首页!-----------");
        return"login";
    }
    @RequestMapping(value = "/dologin.html" ,method = RequestMethod.POST)
    public String doLogin(@RequestParam(value = "userCode")String userCode,
                          @RequestParam(value = "userPassword")String userPassword,
                          HttpSession session, HttpServletRequest request, HttpServletResponse response){

        User user = userService.login(userCode,userPassword);
        if(null !=user) {
            session.setAttribute(Constants.USER_SESSION, user);
            System.out.println(user.getAddress());
            return "redirect:/user/main.html";//重定向

        }else {
            request.setAttribute("error", "账号或密码错误！");
            return "login";
        }
    }
    @RequestMapping(value="/main.html")
    public String main(HttpSession session) {
        if(session.getAttribute(Constants.USER_SESSION )== null) {
            return "redirect:/user/login.html";
        }
        return "frame";

    }
    @RequestMapping(value="exlogin.html",method=RequestMethod.GET)
    public String exLogin(@RequestParam String userCode,@RequestParam String userPassword) {
        looger.info("exLogin--------------------");
        User user =userService.login(userCode, userPassword);
        if(null==user) {
            throw new RuntimeException("用户名或密码错误！");
        }
        return"redirect:/user/main.html";
    }
    /**
     * 用户管理页面
     * @param model
     * @param queryUserName
     * @param queryUserRole
     * @param pageIndex
     * @return
     */
    @RequestMapping(value="/userlist.html")
    public  String getUserList(Model model, @RequestParam(value = "queryname",required = false)String queryUserName,
                               @RequestParam(value = "queryUserRole" ,required = false) String queryUserRole,
                               @RequestParam(value = "pageIndex",required = false) String pageIndex){
             userService.getdemo();
        return "userlist";
    }
}
