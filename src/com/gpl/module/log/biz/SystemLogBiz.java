package com.gpl.module.log.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.log.dao.SystemLogDao;
import com.gpl.module.log.model.SystemLog;

@Service
public class SystemLogBiz extends BaseBiz<SystemLog, Integer>{

	@Autowired
	private SystemLogDao systemLogDao;

	public Page queryPage(Page page) {
		String hql = "from SystemLog where 1=1";
		List<Object> params = new ArrayList<Object>();
		if(page.getParams().get("id") != null){
			hql += " and id = ?";
			params.add(Integer.valueOf(page.getParams().get("id").toString()));
		}
		if(page.getParams().get("account") != null){
			hql += " and account like ?";
			params.add("%" + page.getParams().get("account") + "%");
		}
		if(page.getParams().get("method") != null){
			hql += " and method like ?";
			params.add("%" + page.getParams().get("method") + "%");
		}
		if(page.getParams().get("type") != null){
			hql += " and type = ?";
			params.add(Integer.valueOf(page.getParams().get("type").toString()));
		}
		if(page.getParams().get("ecode") != null){
			hql += " and ecode = ?";
			params.add(page.getParams().get("ecode"));
		}
		if(page.getParams().get("startTime") != null){
			hql += " and createTime >= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("startTime"));
		}
		if(page.getParams().get("endTime") != null){
			hql += " and createTime <= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("endTime"));
		}
		hql += " order by createTime desc";
		return systemLogDao.findPage(page, hql, params.toArray());
	}
}
