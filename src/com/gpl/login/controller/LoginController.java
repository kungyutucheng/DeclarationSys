package com.gpl.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.authorization.biz.UserBiz;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserBiz userBiz;
	
	@RequestMapping(path = "login",method = RequestMethod.POST)
	public ModelAndView login(String account,String password,boolean isRememberMe){
		if(userBiz.isUserExist(account, password)){
			return new ModelAndView("home/home");
		}else{
			ModelAndView modelAndView = new ModelAndView("login/login");
			modelAndView.addObject("errorMsg", "用户名或密码错误");
			return modelAndView;
		}
	}
}
