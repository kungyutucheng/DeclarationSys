package com.gpl.module.log.biz;

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
		return loginLogDao.findPage(page, hql, page.getParams());
	}
}
