package com.gpl.module.entry.biz;

import org.apache.commons.collections.map.HashedMap;
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
		String hql = "select new EntryGoodVO(id,"
				+ "eid,"
				+ "contId,"
				+ "(select conNo from EntryCon ec where ec.id=contId),"
				+ "cbeComId,"
				+ "(select ename from Enterprise ent where ent.id=cbeComId),"
				+ "hsCode,"
				+ "ciqGoodsCode,"
				+ "gCode,"
				+ "goodsMaterial,"
				+ "packType,"
				+ "(select name from Package p where p.code=packType),"
				+ "fCode,"
				+ "(select name from Currency c where c.code=fCode),"
				+ "uPric,"
				+ "buyFromCity,"
				+ "qtp,"
				+ "qtpUnit,"
				+ "(select name from Unit u where u.code=qtpUnit),"
				+ "qty,"
				+ "qtyDesc,"
				+ "kgs,"
				+ "net,"
				+ "fcy,"
				+ "kgsUnit,"
				+ "packNum,"
				+ "goodsBatchNo,"
				+ "packPieceNum,"
				+ "createTime) from EntryGood where 1=1";
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
			hql += " and uPric>=" + page.getParams().get("startUPric");
		}
		if(page.getParams().get("endUPric") != null){
			hql += " and UPric<=" + page.getParams().get("endUPric");
		}
		if(page.getParams().get("buyFromCity") != null){
			hql += " and buyFromCity like '%" + page.getParams().get("buyFromCity") + "%'";
		}
		if(page.getParams().get("startQtp") != null){
			hql += " and qtp>=" + page.getParams().get("startQtp");
		}
		if(page.getParams().get("endQtp") != null){
			hql += " and qtp<=" + page.getParams().get("endQtp");
		}
		if(page.getParams().get("qtpUnit") != null){
			hql += " and qtpUnit='" + page.getParams().get("qtpUnit") +"'";
		}
		if(page.getParams().get("startQty") != null){
			hql += " and qty>=" + page.getParams().get("startQty");
		}
		if(page.getParams().get("endQty") != null){
			hql += " and qty<=" + page.getParams().get("endQty");
		}
		if(page.getParams().get("startKgs") != null){
			hql += " and kgs>=" + page.getParams().get("kgs");
		}
		if(page.getParams().get("endKgs") != null){
			hql += " and kgs<=" + page.getParams().get("endKgs");
		}
		if(page.getParams().get("startNet") != null){
			hql += " and net>=" + page.getParams().get("startNet");
		}
		if(page.getParams().get("endNet") != null){
			hql += " and net<=" + page.getParams().get("endNet");
		}
		if(page.getParams().get("startFcy") != null){
			hql += " and fcy>=" + page.getParams().get("startFcy");
		}
		if(page.getParams().get("endFcy") != null){
			hql += " and fcy<=" + page.getParams().get("endFcy");
		}
		if(page.getParams().get("kgsUnit") != null){
			hql += " and kgsUnit='" + page.getParams().get("kgsUnit") + "'";
		}
		if(page.getParams().get("startPackNum") != null){
			hql += " and packNum>=" + page.getParams().get("startPackNum");
		}
		if(page.getParams().get("endPackNum") != null){
			hql += " and packNum<=" + page.getParams().get("endPackNum");
		}
		if(page.getParams().get("goodsBatchNo") != null){
			hql += " and goodsBatchNo like '%" + page.getParams().get("goodsBatchNo") + "%'";
		}
		if(page.getParams().get("startPackPieceNum") != null){
			hql += " and packPieceNum>=" + page.getParams().get("startPackPieceNum");
		}
		if(page.getParams().get("endPackPieceNum") != null){
			hql += " and packPieceNum<=" + page.getParams().get("endPackPieceNum");
		}
		if(page.getParams().get("startTime") != null){
			hql += " and createTime >='" + page.getParams().get("startTime") + "'";
		}
		if(page.getParams().get("endTime") != null){
			hql += " and createTime <='" + page.getParams().get("endTime") + "'";
		}
		hql += " order by createTime desc";
		return entryGoodDao.findPage(page, hql);
	}
}
