package com.gpl.module.entry.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.annotation.SystemBizLog;
import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.entry.dao.EntryGoodDao;
import com.gpl.module.entry.model.EntryGood;

@Service
public class EntryGoodBiz extends BaseBiz<EntryGood, Integer>{

	@Autowired
	private EntryGoodDao entryGoodDao;

	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	@SystemBizLog(desc = "分页查询")
	public Page queryPage(Page page) {
		String hql = "select new EntryGoodVO(id,"
				+ "eid,"
				+ "contId,"
				+ "(select conNo from EntryCon ec where ec.id=contId),"
				+ "cbeComId,"
				+ "(select ename from Enterprise ent where ent.id=cbeComId),"
				+ "hsCode,"
				+ "ciqGoodsNo,"
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
		List<Object> params = new ArrayList<Object>();
		if(page.getParams().get("eid") != null){
			hql += " and eid = ?";
			params.add(Integer.valueOf(page.getParams().get("eid").toString()));
		}
		if(page.getParams().get("contId") != null){
			hql += " and contId = ?";
			params.add(Integer.valueOf(page.getParams().get("contId").toString()));
		}
		if(page.getParams().get("hsCode") != null){
			hql += " and hsCode like ?";
			params.add("%" + page.getParams().get("hsCode") + "%");
		}
		if(page.getParams().get("ciqGoodsNo") != null){
			hql += " and ciqGoodsNo like ?";
			params.add("%" + page.getParams().get("ciqGoodsNo") + "%");
		}
		if(page.getParams().get("gCode") != null){
			hql += " and gCode like ?";
			params.add("%" + page.getParams().get("gCode") + "%");
		}
		if(page.getParams().get("goodsMaterial") != null){
			hql += " and goodsMaterial like ?";
			params.add("%" + page.getParams().get("goodsMaterial") + "%");
		}
		if(page.getParams().get("packType") != null){
			hql += " and packType = ?";
			params.add(page.getParams().get("packType")); 
		}
		if(page.getParams().get("fCode") != null){
			hql += " and fCode = ?";
			params.add(page.getParams().get("fCode"));
		}
		if(page.getParams().get("startUPric") != null){
			hql += " and uPric >= ?";
			params.add(new BigDecimal(page.getParams().get("startUPric").toString()));
		}
		if(page.getParams().get("endUPric") != null){
			hql += " and UPric <= ?";
			params.add(new BigDecimal(page.getParams().get("endUPric").toString()));
		}
		if(page.getParams().get("buyFromCity") != null){
			hql += " and buyFromCity like ?";
			params.add("%" + page.getParams().get("buyFromCity") + "%");
		}
		if(page.getParams().get("startQtp") != null){
			hql += " and qtp >= ?";
			params.add(new BigDecimal(page.getParams().get("startQtp").toString()));
		}
		if(page.getParams().get("endQtp") != null){
			hql += " and qtp <= ?";
			params.add(new BigDecimal(page.getParams().get("endQtp").toString()));
		}
		if(page.getParams().get("qtpUnit") != null){
			hql += " and qtpUnit = ?";
			params.add(page.getParams().get("qtpUnit"));
		}
		if(page.getParams().get("startQty") != null){
			hql += " and qty >= ?";
			params.add(new BigDecimal(page.getParams().get("startQty").toString()));
		}
		if(page.getParams().get("endQty") != null){
			hql += " and qty <= ?";
			params.add(new BigDecimal(page.getParams().get("endQty").toString()));
		}
		if(page.getParams().get("startKgs") != null){
			hql += " and kgs >= ?";
			params.add(new BigDecimal(page.getParams().get("kgs").toString()));
		}
		if(page.getParams().get("endKgs") != null){
			hql += " and kgs <= ?";
			params.add(new BigDecimal(page.getParams().get("endKgs").toString()));
		}
		if(page.getParams().get("startNet") != null){
			hql += " and net >= ?";
			params.add(new BigDecimal(page.getParams().get("startNet").toString()));
		}
		if(page.getParams().get("endNet") != null){
			hql += " and net <= ?";
			params.add(new BigDecimal(page.getParams().get("endNet").toString()));
		}
		if(page.getParams().get("startFcy") != null){
			hql += " and fcy >= ?";
			params.add(new BigDecimal(page.getParams().get("startFcy").toString()));
		}
		if(page.getParams().get("endFcy") != null){
			hql += " and fcy <= ?";
			params.add(new BigDecimal(page.getParams().get("endFcy").toString()));
		}
		if(page.getParams().get("kgsUnit") != null){
			hql += " and kgsUnit = ?";
			params.add(page.getParams().get("kgsUnit"));
		}
		if(page.getParams().get("startPackNum") != null){
			hql += " and packNum >= ?";
			params.add(Integer.valueOf(page.getParams().get("startPackNum").toString()));
		}
		if(page.getParams().get("endPackNum") != null){
			hql += " and packNum <= ?";
			params.add(Integer.valueOf(page.getParams().get("endPackNum").toString()));
		}
		if(page.getParams().get("goodsBatchNo") != null){
			hql += " and goodsBatchNo like ?";
			params.add("%" + page.getParams().get("goodsBatchNo") + "%");
		}
		if(page.getParams().get("startPackPieceNum") != null){
			hql += " and packPieceNum >= ?";
			params.add(Integer.valueOf(page.getParams().get("startPackPieceNum").toString()));
		}
		if(page.getParams().get("endPackPieceNum") != null){
			hql += " and packPieceNum <= ?";
			params.add(Integer.valueOf(page.getParams().get("endPackPieceNum").toString()));
		}
		if(page.getParams().get("startTime") != null){
			hql += " and createTime >= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("startTime"));
		}
		if(page.getParams().get("endTime") != null){
			hql += " and createTime <= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
			params.add(page.getParams().get("endTime"));
		}
		hql += " order by createTime desc";
		return entryGoodDao.findPage(page, hql,params.toArray());
	}
}
