package com.gpl.module.entry.biz;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.entry.dao.EntryConDao;
import com.gpl.module.entry.model.EntryCon;

@Service
public class EntryConBiz extends BaseBiz<EntryCon, Integer>{

	@Autowired
	private EntryConDao entryConDao;

	public Page queryPage(Page page) {
		String hql = "from EntryCon where 1=1";
		if(page.getParams().get("eid") != null){
			hql += " and eid=" + page.getParams().get("eid");
		}
		if(page.getParams().get("conNo") != null){
			hql += " and conNo like '%" + page.getParams().get("conNo") + "%'";
		}
		if(page.getParams().get("conSize") != null){
			hql += " and conSize='" + page.getParams().get("conSize") + "'";
		}
		if(page.getParams().get("conType") != null){
			hql += " and conType='" + page.getParams().get("conType") + "'";
		}
		if(page.getParams().get("sealNo") != null){
			hql += " and sealNo like '%" + page.getParams().get("sealNo") + "%'";
		}
		hql += " order by createTime desc";
		return entryConDao.findPage(page,hql,new HashMap<String,Object>());
	}
}
