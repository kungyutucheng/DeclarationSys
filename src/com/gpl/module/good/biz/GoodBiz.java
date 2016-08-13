package com.gpl.module.good.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.good.dao.GoodDao;
import com.gpl.module.good.model.Good;

@Service
public class GoodBiz extends BaseBiz<Good, Integer>{
	
	@Autowired
	private GoodDao goodDao;
	
	public List<Good> getAll(){
		String hql = "from Good";
		return goodDao.find(hql);
	}
	
	public List<Good> queryPage(Page page){
		String hql = "select g.id id,g.from Good g";
		return goodDao.find(hql);
	}
}
