package com.gpl.module.entry.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.annotation.SystemBizLog;
import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.entry.dao.EntryConDao;
import com.gpl.module.entry.model.EntryCon;

@Service
public class EntryConBiz extends BaseBiz<EntryCon, Integer>{

	@Autowired
	private EntryConDao entryConDao;

	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	@SystemBizLog(desc = "分页查询")
	public Page queryPage(Page page) {
		String hql = "from EntryCon where 1=1";
		List<Object> params = new ArrayList<Object>();
		if(page.getParams().get("eid") != null){
			hql += " and eid = ?";
			params.add(Integer.valueOf(page.getParams().get("eid").toString()));
		}
		if(page.getParams().get("conNo") != null){
			hql += " and conNo like ?";
			params.add("%" + page.getParams().get("conNo") + "%");
		}
		if(page.getParams().get("conSize") != null){
			hql += " and conSize = ?";
			params.add(page.getParams().get("conSize"));
		}
		if(page.getParams().get("conType") != null){
			hql += " and conType = ?";
			params.add(page.getParams().get("conType"));
		}
		if(page.getParams().get("sealNo") != null){
			hql += " and sealNo like ?";
			params.add("%" + page.getParams().get("sealNo") + "%");
		}
		hql += " order by createTime desc";
		return entryConDao.findPage(page,hql,params.toArray());
	}
	
	/**
	 * 根据eid获取全部箱数据
	 * @return
	 */
	@SystemBizLog(desc = "根据eid获取全部箱数据")
	public List<EntryCon> getConByEid(Integer eid){
		String hql = "from EntryCon where eid=:eid";
		Map<String,Object> values = new HashMap<String,Object>();
		values.put("eid", eid);
		return entryConDao.find(hql, values);
	}
}
