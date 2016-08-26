package com.gpl.module.good.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jms.MessageNotWriteableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gpl.framework.annotation.SystemBizLog;
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
	
	@SystemBizLog(desc = "分页查询")
	public Page queryPage(Page page){
		List<Object> params = new ArrayList<Object>();
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
				hql += " and g.id = ?";
				params.add(Integer.valueOf(page.getParams().get("id").toString()));
			}
			if(page.getParams().get("ciqGoodsNo") != null){
				hql += " and g.ciqGoodsNo like ?";
				params.add("%" + page.getParams().get("ciqGoodsNo") + "%");
			}
			if(page.getParams().get("status") != null){
				hql += " and g.status = ?";
				params.add(Integer.valueOf(page.getParams().get("status").toString()));
			}
			if(page.getParams().get("gCode") != null){
				hql += " and g.gCode like ?";
				params.add("%" + page.getParams().get("gCode") + "%");
			}
			if(page.getParams().get("startNum") != null){
				hql += " and g.num >= ?";
				params.add(Integer.valueOf(page.getParams().get("startNum").toString()));
			}
			if(page.getParams().get("endNum") != null){
				hql += " and g.num <= ?";
				params.add(Integer.valueOf(page.getParams().get("endNum").toString()));
			}
			if(page.getParams().get("gname") != null){
				hql += " and g.gname like ?";
				params.add("%" + page.getParams().get("gname") + "%");
			}
			if(page.getParams().get("hsCode") != null){
				hql += " and g.hdCode like ?";
				params.add("%" + page.getParams().get("hsCode") + "%");
			}
			if(page.getParams().get("goodsDesc") != null){
				hql += " and g.goodsDesc like ?";
				params.add("%" + page.getParams().get("goodsDesc") + "%");
			}
			if(page.getParams().get("comName") != null){
				hql += " and g.comName like '%" + page.getParams().get("comName") + "%";
			}
			if(page.getParams().get("brand") != null){
				hql += " and g.brand like ?";
				params.add("%" + page.getParams().get("brand") + "%");
			}
			if(page.getParams().get("assemCountry") != null){
				hql += " and g.assemCountry like ?";
				params.add("%" + page.getParams().get("assemCountry") + "%");
			}
			if(page.getParams().get("cargobCode") != null){
				hql += " and g.cargobCode like ?";
				params.add("%" + page.getParams().get("cargobCode") + "%");
			}
			if(page.getParams().get("ciqbCode") != null){
				hql += " and gm.ciqbCode = ?";
				params.add(page.getParams().get("ciqbCode"));
			}
			if(page.getParams().get("cbeComId") != null){
				hql += " and gm.cbeComId = ?";
				params.add(Integer.valueOf(page.getParams().get("cbeComId").toString()));
			}
			if(page.getParams().get("editId") != null){
				hql += " and gm.editId = ?";
				params.add(Integer.valueOf(page.getParams().get("editId").toString()));
			}
			if(page.getParams().get("operType") != null){
				hql += " and gm.operType = ?";
				params.add(page.getParams().get("operType")); 
			}
			if(page.getParams().get("startTime") != null){
				hql += " and g.createTime >= STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s')";
				params.add(page.getParams().get("startTime"));
			}
			if(page.getParams().get("endTime") != null){
				hql += " and g.createTime <= ?";
				params.add(page.getParams().get("endTime"));
			}
			if(page.getParams().get("noNotNull") != null){
				hql += " and g.ciqGoodsNo is not null";
			}
			if(page.getParams().get("gmid") != null){
				hql += " and gmid = ?";
				params.add(Integer.valueOf(page.getParams().get("gmid").toString()));
			}
			if(page.getParams().get("applicant") != null){
				hql += " and gm.applicant like ?";
				params.add("%" + page.getParams().get("applicant") + "%");
			}
			hql	+= " order by g.createTime desc";
		return goodDao.findPage(page, hql, params.toArray());
	}
	
	public void batchUpdate(Integer gmid){
		String hql = "update Good set status=1 where gmid=" + gmid;
		goodDao.batchExecute(hql, new HashMap<String,Object>());
	}
}
