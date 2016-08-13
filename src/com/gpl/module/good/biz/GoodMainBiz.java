package com.gpl.module.good.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.good.dao.GoodMainDao;
import com.gpl.module.good.model.GoodMain;

@Service
public class GoodMainBiz extends BaseBiz<GoodMain, Integer>{

	@Autowired
	private GoodMainDao goodMainDao;
	
}
