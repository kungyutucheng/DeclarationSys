package com.gpl.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpl.authorization.biz.UserBiz;
import com.gpl.framework.base.controller.BaseController;
import com.gpl.framework.model.AjaxModel;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Autowired
	private UserBiz userBiz;
	
	@RequestMapping(path = "/getModules",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getModules(){
		AjaxModel model = new AjaxModel();
		boolean success = true;
		String msg = "��ȡ���ݳɹ�";
		try{
			System.out.println(userBiz.getModules(getString("account")).toString());
			model.setData(userBiz.getModules(getString("account")));
		}catch(Exception e){
			msg = "��ȡ����ʧ��";
			success = false;
		}
		model.setSuccess(success);
		model.setMsg(msg);
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/test",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String test(){
		return renderJsonStr(userBiz.getModules("admin"));
	}
}
