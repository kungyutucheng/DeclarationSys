package com.gpl.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.authorization.biz.UserBiz;
import com.gpl.authorization.model.User;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserBiz userBiz;
	
	@RequestMapping(path = "loginPage",method = RequestMethod.GET)
	public ModelAndView loginPage(){
		return new ModelAndView("login/login");
	}
	
	@RequestMapping(path = "login",method = RequestMethod.POST)
	public ModelAndView login(HttpSession session ,String account,String password,boolean isRememberMe){
		if(userBiz.isUserExist(account, password)){
			User user = new User();
			user.setAccount(account);
			user.setPassword(password);
			session.setAttribute("user", user);
			return new ModelAndView("home/home2");
		}else{
			ModelAndView modelAndView = new ModelAndView("login/login");
			modelAndView.addObject("errorMsg", "用户名或密码错误");
			return modelAndView;
		}
	}
}
