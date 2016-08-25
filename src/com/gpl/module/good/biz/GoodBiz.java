package com.gpl.module.good.biz;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jms.MessageNotWriteableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.good.dao.GoodDao;
import com.gpl.module.good.model.Good;

@Service
@Transactional
public class GoodBiz extends BaseBiz<Good, Integer>{
	
	@Autowired
	private GoodDao goodDao;
	
	public List<Good> getAll(){
		String hql = "from Good";
		return goodDao.find(hql);
	}
	public Page queryPage(Page page){
		String hql = "select new GoodVO(g.id ,"
				+ "g.gCode,"
				+ "g.gname,"
				+ "g.spec,"
				+ "g.hsCode,"
				+ "g.unit,"
				+ "g.goodsDesc,"
				+ "g.gRemark,"
				+ "g.comName,"
				+ "g.manufactureAddr,"
				+ "g.brand,"
				+ "g.assemCountry,"
				+ "g.ingredient,"
				+ "g.additiveFlag,"
				+ "g.poisonFlag,"
				+ "g.num,"
				+ "g.ciqGoodsNo,"
				+ "g.status,"
				+ "g.regNotes,"
				+ "g.gmid,"
				+ "gm.cargobCode,"
				+ "(select name from Organization o where o.code = gm.ciqbCode),"
				+ "(select ename from Enterprise e where e.id = gm.cbeComId),"
				+ "gm.remark,"
				+ "(select ename from Enterprise e where e.id = gm.editId),"
				+ "gm.operType,"
				+ "g.createTime,"
				+ "gm.applicant"
				+ ")"
				+ " from Good g,GoodMain gm where g.gmid = gm.id";
			if(page.getParams().get("id") != null){
				hql += " and g.id=" + page.getParams().get("id");
			}
			if(page.getParams().get("ciqGoodsNo") != null){
				hql += " and g.ciqGoodsNo like '%" + page.getParams().get("ciqGoodsNo") + "%'";
			}
			if(page.getParams().get("status") != null){
				hql += " and g.status=" + page.getParams().get("status");
			}
			if(page.getParams().get("gCode") != null){
				hql += " and g.gCode like '%" + page.getParams().get("gCode") +"%'";
			}
			if(page.getParams().get("startNum") != null){
				hql += " and g.num>=" + page.getParams().get("startNum");
			}
			if(page.getParams().get("endNum") != null){
				hql += " and g.num<=" + page.getParams().get("endNum");
			}
			if(page.getParams().get("gname") != null){
				hql += " and g.gname like '%" + page.getParams().get("gname") + "%'";
			}
			if(page.getParams().get("hsCode") != null){
				hql += " and g.hdCode like '%" + page.getParams().get("hsCode") + "%'";
			}
			if(page.getParams().get("goodsDesc") != null){
				hql += " and g.goodsDesc like '%" + page.getParams().get("goodsDesc") + "%'";
			}
			if(page.getParams().get("comName") != null){
				hql += " and g.comName like '%" + page.getParams().get("comName") + "%'";
			}
			if(page.getParams().get("brand") != null){
				hql += " and g.brand like '%" + page.getParams().get("brand") + "%'";
			}
			if(page.getParams().get("assemCountry") != null){
				hql += " and g.assemCountry like '%" + page.getParams().get("assemCountry") + "%'";
			}
			if(page.getParams().get("cargobCode") != null){
				hql += " and g.cargobCode like '%" + page.getParams().get("cargobCode") + "%'";
			}
			if(page.getParams().get("ciqbCode") != null){
				hql += " and gm.ciqbCode='" + page.getParams().get("ciqbCode") + "'";
			}
			if(page.getParams().get("cbeComId") != null){
				hql += " and gm.cbeComId=" + page.getParams().get("cbeComId");
			}
			if(page.getParams().get("editId") != null){
				hql += " and gm.editId=" + page.getParams().get("editId");
			}
			if(page.getParams().get("operType") != null){
				hql += " and gm.operType='" + page.getParams().get("operType") +"'"; 
			}
			if(page.getParams().get("startTime") != null){
				hql += " and g.createTime>='" + page.getParams().get("startTime") +"'";
			}
			if(page.getParams().get("endTime") != null){
				hql += " and g.createTime <='" + page.getParams().get("endTime") +"'";
			}
			if(page.getParams().get("noNotNull") != null){
				hql += " and g.ciqGoodsNo is not null";
			}
			if(page.getParams().get("gmid") != null){
				hql += " and gmid=" + page.getParams().get("gmid");
			}
			if(page.getParams().get("applicant") != null){
				hql += " and gm.applicant like '%" + page.getParams().get("applicant") + "%'";
			}
			hql	+= " order by g.createTime desc";
		return goodDao.findPage(page, hql, new HashMap<String,Object>());
	}
	
	public void batchUpdate(Integer gmid){
		String hql = "update Good set status=1 where gmid=" + gmid;
		goodDao.batchExecute(hql, new HashMap<String,Object>());
	}
}
