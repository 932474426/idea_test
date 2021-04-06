package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.RegisterService;
import com.example.demo.service.SendMail;
import com.example.demo.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private SendMail mailService;
    @Autowired
    private RegisterService registerService;
    private String toEmail = "932474426@qq.com";		// 填写你的qq邮箱号
    @GetMapping("/login")
    public String login(HttpServletRequest request)
    {
        return "login";
    }
    @PostMapping("/getinfo")
    public ModelAndView hello(HttpServletRequest request) {
        ModelAndView  modelAndView = new ModelAndView("login");
        if (!CodeUtil.checkVerifyCode(request)) {
            modelAndView.addObject("message","验证码有误！");
        } else {
            String email = request.getParameter("email");
            String password=request.getParameter("new_password");
            System.out.println("email:"+email);
            User user=new User(email,password);
            if(registerService.insert(user)) {
                modelAndView.addObject("success", "注册成功，已发送邮箱告知！");
                mailService.sendTextMail(toEmail, "注册", "恭喜你注册成功！");
            }
            else
            {
                modelAndView.addObject("success", "注册失败，该邮箱已注册！");
            }
        }
        return  modelAndView;
    }
    @GetMapping("/getinfo")
    public String ToLogin()
    {
        return "login";
    }
}
