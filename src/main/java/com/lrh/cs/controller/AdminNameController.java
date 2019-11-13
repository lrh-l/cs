package com.lrh.cs.controller;

import com.lrh.cs.pojo.Medal;
import com.lrh.cs.pojo.User;
import com.lrh.cs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
@Controller
@RequestMapping(value = "/itAccountInfo")
public class AdminNameController {
    @Resource
   private UserService userService;

    @RequestMapping(value = "/index" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String addIndex(){
        System.out.println("0000000000000000000000");
        return "medal";
    }
    @RequestMapping(value = "/queryAdminName.html" ,method ={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView queryAdminName(@RequestParam (value = "adminName") String adminName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminName");
        List<User> bylikeNameList = userService.getBylikeNameList(adminName);
        modelAndView.addObject("user",bylikeNameList);
    return modelAndView;
    }
    @RequestMapping(value = "/save.html" ,method ={RequestMethod.GET,RequestMethod.POST})
    public String save(Medal medal){
       System.out.println("1111");
      return null;

    }
}
