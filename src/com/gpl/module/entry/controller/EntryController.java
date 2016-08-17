package com.gpl.module.entry.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.framework.base.controller.BaseController;
import com.gpl.framework.model.AjaxModel;
import com.gpl.framework.util.Page;
import com.gpl.module.entry.biz.EntryBiz;
import com.gpl.module.entry.biz.EntryConBiz;
import com.gpl.module.entry.biz.EntryGoodBiz;
import com.gpl.module.entry.model.Entry;
import com.gpl.module.entry.model.EntryCon;
import com.gpl.module.entry.model.EntryGood;
import com.gpl.module.util.Creator;

@Controller
@RequestMapping(path = "/entry")
public class EntryController extends BaseController{

	@Autowired
	private EntryBiz entryBiz;
	
	@Autowired
	private EntryConBiz entryConBiz;
	
	@Autowired
	private EntryGoodBiz entryGoodBiz;
	
	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public ModelAndView list(){
		return new ModelAndView("entry/list");
	}
	
	@RequestMapping(path = "/apply",method = RequestMethod.GET)
	public ModelAndView apply(){
		return new ModelAndView("entry/apply");
	}
	
	@RequestMapping(path = "/saveEntry",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String saveEntry(Entry entry){
		System.out.println("bargainNo:" + getString("bargainNo"));
		System.out.println(entry.toString());
		AjaxModel model = new AjaxModel(true);
		model.setMsg("��ӳɹ�");
		try{
			entry.setEntInboundNo(Creator.createEntInboundNo());
			entry.setStatus(1);
			entry.setOperType("A");
			model.setData(entryBiz.save(entry));
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg("ϵͳ�������ʧ��");
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	
	@RequestMapping(path = "/getCon",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getCon(){
		Page page = getPage();
		page.setParams(getAllParams());
		page = entryConBiz.queryPage(page);
		return renderJsonStr(page);
	}
	
	@RequestMapping(path = "/saveCon",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String saveCon(EntryCon con){
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
	public String deleteCon(String ids){
		System.out.println(ids.toString());
		String [] idArray = ids.split(",");
		AjaxModel model = new AjaxModel(true);
		model.setMsg("ɾ���ɹ�");
		try{
			for(String id : idArray){
				EntryCon con = new EntryCon();
				con.setId(Integer.valueOf(id));
				entryConBiz.delete(con);
			}
		}catch(Exception e){
			e.printStackTrace();
			model.setSuccess(false);
			model.setMsg("ϵͳ����ɾ��ʧ��");
		}
		
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/getGood",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getGood(){
		Page page = getPage();
		page.setParams(getAllParams());
		page = entryGoodBiz.queryPage(page);
		return renderJsonStr(page);
	}
	
	@RequestMapping(path = "/saveGood",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String saveGood(EntryGood entryGood){
		AjaxModel model = new AjaxModel(true);
		model.setMsg("��ӳɹ�");
		try{
			entryGoodBiz.save(entryGood);
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg("ϵͳ�������ʧ��");
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/updateGood",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String updateGood(EntryGood entryGood){
		AjaxModel model = new AjaxModel(true);
		model.setMsg("�޸ĳɹ�");
		try{
			entryGoodBiz.saveOrUpdate(entryGood);
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg("ϵͳ�����޸�ʧ��");
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/deleteGood",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String deleteGood(String ids){
		System.out.println(ids.toString());
		String [] idArray = ids.split(",");
		AjaxModel model = new AjaxModel(true);
		model.setMsg("ɾ���ɹ�");
		try{
			for(String id : idArray){
				EntryGood entryGood = new EntryGood();
				entryGood.setId(Integer.valueOf(id));
				entryGoodBiz.delete(entryGood);
			}
		}catch(Exception e){
			e.printStackTrace();
			model.setSuccess(false);
			model.setMsg("ϵͳ����ɾ��ʧ��");
		}
		
		return renderJsonStr(model);
	}
}
