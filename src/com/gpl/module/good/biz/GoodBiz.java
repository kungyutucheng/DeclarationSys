package com.gpl.module.good.biz;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.good.dao.GoodDao;
import com.gpl.module.good.model.Good;
import com.gpl.module.good.vo.GoodVO;

@Service
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
				+ "g.createTime"
				+ ")"
				+ " from Good g,GoodMain gm where g.gmid = gm.id"
				+ " order by g.createTime desc";
		return goodDao.findPage(page, hql, new HashMap<String,Object>());
	}
}
