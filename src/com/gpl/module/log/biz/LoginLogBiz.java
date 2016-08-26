package com.gpl.module.log.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.log.dao.LoginLogDao;
import com.gpl.module.log.model.LoginLog;

@Service
public class LoginLogBiz extends BaseBiz<LoginLog, Integer>{

	@Autowired
	private LoginLogDao loginLogDao;

	public Page queryPage(Page page) {
		String hql = "from LoginLog where 1=1";
		List<Object> params = new ArrayList<Object>(); 
		if(page.getParams().get("account") != null){
			hql += " and account like ?";
			params.add("%" + page.getParams().get("account").toString() + "%");
		}
		if(page.getParams().get("ip") != null){
			hql += " and ip=?";
			params.add(page.getParams().get("ip").toString());
		}
		if(page.getParams().get("result") != null){
			hql += " and result = ?";
			params.add(Integer.valueOf((String) page.getParams().get("result")));
		}
		if(page.getParams().get("startTime") != null){
			hql += " and loginTime >= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("startTime").toString());
		}
		if(page.getParams().get("endTime") != null){
			hql += " and loginTime <= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("endTime").toString());
		}
		hql += " order by loginTime desc";
		return loginLogDao.findPage(page, hql, params.toArray());
	}
}
