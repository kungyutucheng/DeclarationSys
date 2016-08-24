package com.gpl.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.authorization.biz.UserBiz;
import com.gpl.authorization.model.User;
import com.gpl.framework.context.UserContext;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserBiz userBiz;
	
	/**
	 * 访问登录页面
	 * @return 登录页面
	 */
	@RequestMapping(path = "/loginPage",method = RequestMethod.GET)
	public ModelAndView loginPage(){
		return new ModelAndView("login/login");
	}
	
	/**
	 * 用户登录
	 * @param session
	 * @param account
	 * @param password
	 * @param isRememberMe
	 * @return 登录成功进入主页，失败返回错误信息
	 */
	@RequestMapping(path = "/login",method = RequestMethod.POST)
	public ModelAndView login(HttpSession session ,String account,String password,boolean isRememberMe){
		if(userBiz.isUserExist(account, password)){
			User user = new User();
			user.setAccount(account);
			user.setPassword(password);
			session.setAttribute("user", user);
			//将当前用户放到上下文当中
			UserContext.setContext(user);
			return new ModelAndView("home/home");
		}else{
			ModelAndView modelAndView = new ModelAndView("login/login");
			modelAndView.addObject("errorMsg", "用户名或密码错误");
			return modelAndView;
		}
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping(path = "/logout",method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session){
		//从session中移除登录信息
		session.removeAttribute("user");
		//清空上下文环境
		UserContext.setContext(null);
		return new ModelAndView("redirect:loginPage");
	}
}
