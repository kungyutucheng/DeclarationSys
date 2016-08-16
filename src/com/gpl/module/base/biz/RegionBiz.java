package com.gpl.module.base.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.base.dao.RegionDao;
import com.gpl.module.base.model.Region;

@Service
public class RegionBiz extends BaseBiz<Region, Integer>{

	@Autowired
	private RegionDao regionDao;
}
