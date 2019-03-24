package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("user")
public class LoginController {


    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("pwd") String pwd,
                        Map<String ,Object> map,
                        HttpSession session){
        System.out.println("userName =="+userName);
        System.out.println("pwd =="+pwd);
        if (!StringUtils.isEmpty(userName)&&"123".equals(pwd)){
//            return "main";
            session.setAttribute("loginUser",userName);
            return "redirect:/main.html";

        }else {
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
