package com.gpl.module.entry.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.entry.dao.EntryGoodDao;
import com.gpl.module.entry.model.EntryGood;

@Service
public class EntryGoodBiz extends BaseBiz<EntryGood, Integer>{

	@Autowired
	private EntryGoodDao entryGoodDao;

	public Page queryPage(Page page) {
		String hql = "from EntryGood where 1=1";
		if(page.getParams().get("eid") != null){
			hql += " and eid=" + page.getParams().get("eid");
		}
		if(page.getParams().get("contId") != null){
			hql += " and contId=" + page.getParams().get("contId");
		}
		if(page.getParams().get("hsCode") != null){
			hql += " and hsCode like '%" + page.getParams().get("hsCode") + "%'";
		}
		if(page.getParams().get("ciqGoodsCode") != null){
			hql += " and ciqGoodsCode like '%" + page.getParams().get("ciqGoodsCode") + "%'";
		}
		if(page.getParams().get("gCode") != null){
			hql += " and gCode like '%" + page.getParams().get("gCode") + "%'";
		}
		if(page.getParams().get("goodsMaterial") != null){
			hql += " and goodsMaterial like '%" + page.getParams().get("goodsMaterial") + "%'";
		}
		if(page.getParams().get("packType") != null){
			hql += " and packType='" + page.getParams().get("packType") + "'"; 
		}
		if(page.getParams().get("fCode") != null){
			hql += " and fCode='" + page.getParams().get("fCode") + "'";
		}
		if(page.getParams().get("startUPric") != null){
			hql += " and uPric>" + page.getParams().get("startUPric");
		}
		if(page.getParams().get("endUPric") != null){
			hql += " and UPric<" + page.getParams().get("endUPric");
		}
		if(page.getParams().get("buyFromCity") != null){
			hql += " and buyFromCity like '%" + page.getParams().get("buyFromCity") + "%'";
		}
		if(page.getParams().get("startQtp") != null){
			hql += " and qtp>" + page.getParams().get("startQtp");
		}
		if(page.getParams().get("endQtp") != null){
			hql += " and qtp<" + page.getParams().get("endQtp");
		}
		return null;
	}
}
