package com.gpl.module.base.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.base.dao.UnitDao;
import com.gpl.module.base.model.Unit;

@Service
public class UnitBiz extends BaseBiz<Unit, Integer>{
	
	@Autowired
	private UnitDao unitDao;

}
