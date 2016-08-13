package com.gpl.module.good.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.good.dao.GoodDao;
import com.gpl.module.good.model.Good;

@Service
public class GoodBiz extends BaseBiz<Good, Integer>{
	
	@Autowired
	private GoodDao goodDao;
	
	
}
