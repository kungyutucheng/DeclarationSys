package com.gpl.module.good.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.framework.base.controller.BaseController;
import com.gpl.framework.model.AjaxModel;
import com.gpl.framework.util.Page;
import com.gpl.module.good.biz.GoodBiz;
import com.gpl.module.good.biz.GoodMainBiz;
import com.gpl.module.good.dao.GoodDao;
import com.gpl.module.good.dao.GoodMainDao;
import com.gpl.module.good.model.Good;
import com.gpl.module.good.model.GoodMain;
import com.gpl.module.util.Creator;

import net.sf.json.JSONObject;


@Controller
@RequestMapping(path = "/good")
public class GoodController extends BaseController{
	
	@Autowired
	private GoodBiz goodBiz;
	
	@Autowired
	private GoodMainBiz goodMainBiz;
	
	@Autowired
	private GoodDao goodDao;
	
	@Autowired
	private GoodMainDao goodMainDao;
	
	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public ModelAndView list(){
		return new ModelAndView("/good/list");
	}
	
	@RequestMapping(path = "/apply", method = RequestMethod.GET)
	public ModelAndView apply(){
		return new ModelAndView("good/apply");
	}


	@RequestMapping(path = "/save",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	@Transactional
	public String save(){
		AjaxModel model = new AjaxModel(true);
		model.setMsg("添加成功");
		try{
			GoodMain goodMain = new GoodMain();
			goodMain.setCargobCode(Creator.createCargobCode());
			goodMain.setCbeComId(getInt("cbeComId"));
			goodMain.setCiqbCode(getString("ciqbCode"));
			goodMain.setEditId(getInt("editId"));
			goodMain.setRemark(getString("remark"));
			Integer id = goodMainBiz.save(goodMain);
			
			Date date = new Date();
			JSONArray jsonArray = new JSONArray(getString("goods"));
			for(int i = 0;i < jsonArray.length() ;i++){
				Good good = new Good(jsonArray.getJSONObject(i));
				good.setGmid(id);
				good.setCreateTime(date);
				good.setStatus(1);
				goodBiz.save(good);
			}
		}catch(Exception e){
			e.printStackTrace();
			model.setSuccess(false);
			model.setMsg("系统出错，添加失败");
		}
		
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/getNull")
	@ResponseBody
	public String getNull(){
		return "[]";
	}
	
	@RequestMapping(path = "/getAll",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getAll(){
		return renderJsonStr(goodBiz.getAll());
	}
	
	@RequestMapping(path = "/searchgrid",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String searchGrid(){
		Page page = getPage();
		System.out.println(getAllParams().toString());
		page.setParams(getAllParams());
		page = goodBiz.queryPage(page);
		return renderJsonStr(page);
	}
}
