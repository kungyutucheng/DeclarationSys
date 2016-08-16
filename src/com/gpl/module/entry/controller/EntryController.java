package com.gpl.module.entry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.framework.base.controller.BaseController;
import com.gpl.framework.model.AjaxModel;
import com.gpl.framework.util.Page;
import com.gpl.module.entry.biz.EntryConBiz;
import com.gpl.module.entry.model.EntryCon;

@Controller
@RequestMapping(path = "/entry")
public class EntryController extends BaseController{

	@Autowired
	private EntryConBiz entryConBiz;
	
	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public ModelAndView list(){
		return new ModelAndView("entry/list");
	}
	
	@RequestMapping(path = "/apply",method = RequestMethod.GET)
	public ModelAndView apply(){
		return new ModelAndView("entry/apply");
	}
	
	@RequestMapping(path = "/getCon",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String searchGrid(){
		Page page = getPage();
		page.setParams(getAllParams());
		page = entryConBiz.queryPage(page);
		return renderJsonStr(page);
	}
	
	@RequestMapping(path = "/saveCon",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String saveCon(EntryCon con){
		System.out.println(con.toString());
		AjaxModel model = new AjaxModel(true);
		model.setMsg("��ӳɹ�");
		try{
			entryConBiz.save(con);
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg("ϵͳ�������ʧ��");
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/updateCon",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String updateCon(EntryCon con){
		AjaxModel model = new AjaxModel(true);
		model.setMsg("�޸ĳɹ�");
		try{
			entryConBiz.saveOrUpdate(con);
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg("ϵͳ�����޸�ʧ��");
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/deleteCon",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String deleteCon(Integer id){
		System.out.println(id);
		AjaxModel model = new AjaxModel(true);
		model.setMsg("ɾ���ɹ�");
		try{
			entryConBiz.delete(id);
		}catch(Exception e){
			e.printStackTrace();
			model.setSuccess(false);
			model.setMsg("ϵͳ����ɾ��ʧ��");
		}
		
		return renderJsonStr(model);
	}
	
	
}
