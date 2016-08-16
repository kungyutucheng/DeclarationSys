package com.gpl.module.base.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.base.dao.PackageDao;

@Service
public class PackageBiz extends BaseBiz<Package, Integer>{
	
	@Autowired
	private PackageDao packageDao;

}
