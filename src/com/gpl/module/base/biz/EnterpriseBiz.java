package com.gpl.module.base.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.annotation.SystemBizLog;
import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.framework.util.Page;
import com.gpl.module.base.dao.EnterpriseDao;
import com.gpl.module.base.model.Enterprise;

@Service
public class EnterpriseBiz extends BaseBiz<Enterprise, Integer>{

	@Autowired
	private EnterpriseDao enterpriseDao;
	
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	@SystemBizLog(desc = "分页查询")
	public Page queryPage(Page page){
		String hql = "from Enterprise where 1=1";
		if(page != null){
			if(page.getParams().get("id") != null){
				hql += " id = " + page.getParams().get("id").toString();
			}
			if(page.getParams().get("ename") != null){
				hql += " ename like '%" + page.getParams().get("ename").toString() + "%'";
			}
			if(page.getParams().get("ecode") != null){
				hql += " ecode like '%" + page.getParams().get("ecode").toString() + "%'";
			}
			if(page.getParams().get("organization") != null){
				hql += " organization like '%" + page.getParams().get("organization").toString() +"%'";
			}
			if(page.getParams().get("contact") != null){
				hql += " contact like '%" + page.getParams().get("contact").toString() + "%'";
			}
			if(page.getParams().get("telephone") != null){
				hql += " telephone like '%" + page.getParams().get("telephone").toString() + "%'";
			}
			if(page.getParams().get("address") != null){
				hql += " address like '%" + page.getParams().get("address").toString() + "%'";
			}
			if(page.getParams().get("note") != null){
				hql += " note like '%" + page.getParams().get("note").toString() + "%'";
			}
			if(page.getParams().get("startTime") != null){
				
			}
			if(page.getParams().get("endTime") != null){
				
			}
			if(page.getParams().get("recorder") != null){
				hql += " recorder like'%" + page.getParams().get("recorder").toString() + "%'";
			}
		}
		hql += " order by createTime desc";
		return enterpriseDao.findPage(page, hql);
	}
	

}
