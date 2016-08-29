package com.gpl.module.entry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.framework.annotation.SystemControllerLog;
import com.gpl.framework.base.controller.BaseController;
import com.gpl.framework.context.UserContext;
import com.gpl.framework.model.AjaxModel;
import com.gpl.framework.util.Page;
import com.gpl.module.entry.biz.EntryBiz;
import com.gpl.module.entry.biz.EntryConBiz;
import com.gpl.module.entry.biz.EntryGoodBiz;
import com.gpl.module.entry.model.Entry;
import com.gpl.module.entry.model.EntryCon;
import com.gpl.module.entry.model.EntryGood;
import com.gpl.module.util.Creator;

import static com.gpl.framework.model.AjaxModel.SAVE_SUCCESS;
import static com.gpl.framework.model.AjaxModel.SAVE_FAILURE;
import static com.gpl.framework.model.AjaxModel.UPDATE_SUCCESS;
import static com.gpl.framework.model.AjaxModel.UPDATE_FAILURE;
import static com.gpl.framework.model.AjaxModel.DELETE_SUCCESS;
import static com.gpl.framework.model.AjaxModel.DELETE_FAILURE;
import static com.gpl.framework.model.AjaxModel.RECORD_SUCCESS;
import static com.gpl.framework.model.AjaxModel.RECORD_FAILURE;
@Controller
@RequestMapping(path = "/entry")
public class EntryController extends BaseController{

	@Autowired
	private EntryBiz entryBiz;
	
	@Autowired
	private EntryConBiz entryConBiz;
	
	@Autowired
	private EntryGoodBiz entryGoodBiz;
	
	/**
	 * 获取入境进区查询页面
	 * @return
	 */
	@SystemControllerLog(desc = "获取入境进区查询页面")
	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public ModelAndView list(){
		return new ModelAndView("entry/list");
	}
	
	/**
	 * 获取入境进区申请页面
	 * @return
	 */
	@SystemControllerLog(desc = "获取入境进区申请页面")
	@RequestMapping(path = "/apply",method = RequestMethod.GET)
	public ModelAndView apply(){
		return new ModelAndView("entry/apply");
	}
	
	/**
	 * 入境进区分页查询
	 * @return
	 */
	@SystemControllerLog(desc = "入境进区分页查询")
	@RequestMapping(path = "/getEntry",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getEntry(){
		Page page = getPage();
		page.setParams(getAllParams());
		return renderJsonStr(entryBiz.queryPage(page));
	
	}
	
	/**
	 * 保存入境进区实体
	 * @param entry
	 * @return
	 */
	@SystemControllerLog(desc = "保存入境进区实体")
	@RequestMapping(path = "/saveEntry",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String saveEntry(Entry entry){
		System.out.println(entry);
		AjaxModel model = new AjaxModel(true);
		model.setMsg(SAVE_SUCCESS);
		try{
			entry.setEntInboundNo(Creator.createEntInboundNo());
			entry.setApplicant(UserContext.getContext().getUser().getAccount());
			entry.setStatus(0);
			entry.setOperType("A");
			model.setData(entryBiz.save(entry));
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg(SAVE_FAILURE);
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	/**
	 * 分页查询箱数据
	 * @return
	 */
	@SystemControllerLog(desc = "分页查询箱数据")
	@RequestMapping(path = "/getCon",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getCon(){
		Page page = getPage();
		page.setParams(getAllParams());
		page = entryConBiz.queryPage(page);
		return renderJsonStr(page);
	}
	
	/**
	 * 根据eid获取全部箱数据
	 * @param eid
	 * @return
	 */
	@SystemControllerLog(desc = "根据eid获取全部箱数据")
	@RequestMapping(path = "/getConByEid",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getConByEid(Integer eid){
		return renderJsonStr(entryConBiz.getConByEid(eid));
	}
	
	/**
	 * 保存箱实体
	 * @param con
	 * @return
	 */
	@SystemControllerLog(desc = "保存箱实体")
	@RequestMapping(path = "/saveCon",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String saveCon(EntryCon con){
		AjaxModel model = new AjaxModel(true);
		model.setMsg(SAVE_SUCCESS);
		try{
			entryConBiz.save(con);
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg(SAVE_FAILURE);
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	/**
	 * 更新箱实体
	 * @param con
	 * @return
	 */
	@SystemControllerLog(desc = "更新箱实体")
	@RequestMapping(path = "/updateCon",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String updateCon(EntryCon con){
		AjaxModel model = new AjaxModel(true);
		model.setMsg(UPDATE_SUCCESS);
		try{
			entryConBiz.saveOrUpdate(con);
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg(UPDATE_FAILURE);
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	/**
	 * 批量删除箱实体
	 * @param ids
	 * @return
	 */
	@SystemControllerLog(desc = "批量删除箱实体")
	@RequestMapping(path = "/deleteCon",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String deleteCon(String ids){
		String [] idArray = ids.split(",");
		AjaxModel model = new AjaxModel(true);
		model.setMsg(DELETE_SUCCESS);
		try{
			for(String id : idArray){
				EntryCon con = new EntryCon();
				con.setId(Integer.valueOf(id));
				entryConBiz.delete(con);
			}
		}catch(Exception e){
			e.printStackTrace();
			model.setSuccess(false);
			model.setMsg(DELETE_FAILURE);
		}
		
		return renderJsonStr(model);
	}
	
	/**
	 * 分页查询入境进区商品数据
	 * @return
	 */
	@SystemControllerLog(desc = "分页查询入境进区商品数据")
	@RequestMapping(path = "/getGood",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getGood(){
		Page page = getPage();
		page.setParams(getAllParams());
		page = entryGoodBiz.queryPage(page);
		return renderJsonStr(page);
	}
	
	/**
	 * 保存商品实体
	 * @param entryGood
	 * @return
	 */
	@SystemControllerLog(desc = "保存商品实体")
	@RequestMapping(path = "/saveGood",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String saveGood(EntryGood entryGood){
		AjaxModel model = new AjaxModel(true);
		model.setMsg(SAVE_SUCCESS);
		try{
			entryGood.setFcy(entryGood.getQty().multiply(entryGood.getuPric()));
			entryGoodBiz.save(entryGood);
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg(SAVE_FAILURE);
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	/**
	 * 更新商品实体
	 * @param entryGood
	 * @return
	 */
	@SystemControllerLog(desc = "更新商品实体")
	@RequestMapping(path = "/updateGood",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String updateGood(EntryGood entryGood){
		AjaxModel model = new AjaxModel(true);
		model.setMsg(UPDATE_SUCCESS);
		try{
			entryGood.setFcy(entryGood.getQty().multiply(entryGood.getuPric()));
			entryGoodBiz.saveOrUpdate(entryGood);
		}catch(Exception e){
			e.printStackTrace();
			model.setMsg(UPDATE_FAILURE);
			model.setSuccess(false);
		}
		return renderJsonStr(model);
	}
	
	/**
	 * 批量删除商品实体
	 * @param ids
	 * @return
	 */
	@SystemControllerLog(desc = "批量删除商品实体")
	@RequestMapping(path = "/deleteGood",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String deleteGood(String ids){
		String [] idArray = ids.split(",");
		AjaxModel model = new AjaxModel(true);
		model.setMsg("删除成功");
		try{
			for(String id : idArray){
				EntryGood entryGood = new EntryGood();
				entryGood.setId(Integer.valueOf(id));
				entryGoodBiz.delete(entryGood);
			}
		}catch(Exception e){
			e.printStackTrace();
			model.setSuccess(false);
			model.setMsg("系统出错，删除失败");
		}
		
		return renderJsonStr(model);
	}
	
	/**
	 * 提交入境进区备案
	 * @param id
	 * @return
	 */
	@SystemControllerLog(desc = "提交入境进区备案")
	@RequestMapping(path = "/commit", method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String commit(Integer id){
		AjaxModel model = new AjaxModel(true);
		model.setMsg(RECORD_SUCCESS);
		try{
			Entry entry = entryBiz.get(id, Entry.class.getName());
			entry.setStatus(1);
			entryBiz.update(entry);
		}catch(Exception e){
			e.printStackTrace();
			model.setSuccess(false);
			model.setMsg(RECORD_FAILURE);
		}
		return renderJsonStr(model);
	}
}
