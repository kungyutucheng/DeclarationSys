package com.gpl.module.good.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Commit;
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

import static com.gpl.framework.model.AjaxModel.SAVE_SUCCESS;
import static com.gpl.framework.model.AjaxModel.SAVE_FAILURE;
import static com.gpl.framework.model.AjaxModel.UPDATE_SUCCESS;
import static com.gpl.framework.model.AjaxModel.UPDATE_FAILURE;
import static com.gpl.framework.model.AjaxModel.DELETE_SUCCESS;
import static com.gpl.framework.model.AjaxModel.DELETE_FAILURE;
import static com.gpl.framework.model.AjaxModel.RECORD_SUCCESS;
import static com.gpl.framework.model.AjaxModel.RECORD_FAILURE;

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
		return new ModelAndView("good/apply2");
	}

	@RequestMapping(path = "/saveGoodMain" , method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String saveGoodMain(GoodMain goodMain){
		AjaxModel model = new AjaxModel(true);
		model.setMsg("添加成功");
		try{
			goodMain.setCargobCode(Creator.createCargobCode());
			goodMain.setOperType("A");
			System.out.println(goodMain.toString());
			model.setData(goodMainBiz.save(goodMain));
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg("系统出错，添加失败");
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/updateGoodMain" , method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String updateGoodMain(GoodMain goodMain){
		AjaxModel model = new AjaxModel(true);
		model.setMsg("修改成功");
		try{
			GoodMain goodMain2 = goodMainBiz.get(goodMain.getId(), GoodMain.class.getName());
			goodMain.setCargobCode(goodMain2.getCargobCode());
			goodMain.setOperType("A");
			goodMainBiz.update(goodMain);
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg("系统出错，修改失败");
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}

	@RequestMapping(path = "/saveGood",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String saveGood(Good good){
		AjaxModel model = new AjaxModel(true);
		model.setMsg("添加成功");
		try{
			good.setStatus(0);
			model.setData(goodBiz.save(good));
		}catch(Exception e){
			e.printStackTrace();
			model.setSuccess(false);
			model.setMsg("系统出错，添加失败");
		}
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/updateGood" , method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String updateGood(Good good){
		AjaxModel model = new AjaxModel(true);
		model.setMsg("修改成功");
		try {
			good.setNum(new BigDecimal(0));
			goodBiz.update(good);
		} catch (Exception e) {
			model.setSuccess(false);
			model.setMsg("系统出错，修改失败");
		}
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/deleteGood" , method = RequestMethod.POST , produces = "text/application;charset=utf-8")
	@ResponseBody
	public String deleteGood(String ids){
		AjaxModel model = new AjaxModel(true);
		model.setMsg("删除成功");
		try{
			goodBiz.deleteIds(ids, Good.class.getName());
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg("系统出错，删除失败");
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/getGood" , method = RequestMethod.POST , produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getGood(){
		Page page = getPage();
		page.setParams(getAllParams());
		return renderJsonStr(goodBiz.queryPage(page));
	}
	
	/**
	 * 提交备案，将gmid下的所有商品的状态值从0（新增）修改为1（请求发送）
	 * @param gmid
	 * @return
	 */
	@RequestMapping(path = "/commit" , method = RequestMethod.POST ,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String commit(Integer gmid){
		AjaxModel model = new AjaxModel(true);
		model.setMsg("提交备案成功");
		try{
			goodBiz.batchUpdate(gmid);
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg("系统出错，提交备案失败");
			model.setSuccess(false);
			
		}
		return renderJsonStr(model);
	}
	
	@RequestMapping(path = "/commitGood",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String commitGood(Integer id){
		AjaxModel model = new AjaxModel(true);
		model.setMsg(RECORD_SUCCESS);
		try{
			Good good = goodBiz.get(id, Good.class.getName());
			good.setStatus(1);
			goodBiz.update(good);
		}catch(Exception e){
			e.printStackTrace();
			model.setSuccess(false);
			model.setMsg(RECORD_FAILURE);
		}
		return renderJsonStr(model);
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
		page.setParams(getAllParams());
		page = goodBiz.queryPage(page);
		return renderJsonStr(page);
	}
	
	@RequestMapping(path = "/getGoodById",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getGoodById(){
		return renderJsonStr(goodBiz.get(getInt("id"),Good.class.getName()));
	}
}
