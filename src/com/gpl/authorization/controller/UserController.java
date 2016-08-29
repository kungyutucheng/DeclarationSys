package com.gpl.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpl.authorization.biz.UserBiz;
import com.gpl.framework.annotation.SystemControllerLog;
import com.gpl.framework.base.controller.BaseController;
import com.gpl.framework.model.AjaxModel;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Autowired
	private UserBiz userBiz;
	
	/**
	 * 获取左侧模块数据
	 * @return
	 */
	@RequestMapping(path = "/getModules",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	@SystemControllerLog(desc = "获取左侧模块数据")
	public String getModules(){
		AjaxModel model = new AjaxModel();
		boolean success = true;
		String msg = "获取数据成功";
		try{
			System.out.println(userBiz.getModules(getString("account")).toString());
			model.setData(userBiz.getModules(getString("account")));
		}catch(Exception e){
			msg = "获取数据失败";
			success = false;
		}
		model.setSuccess(success);
		model.setMsg(msg);
		return renderJsonStr(model);
	}
	
}
