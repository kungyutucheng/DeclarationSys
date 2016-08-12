package com.gpl.module.base.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.framework.base.biz.BaseBiz;
import com.gpl.module.base.dao.OrganizationDao;
import com.gpl.module.base.model.Organization;

@Service
public class OrganizationBiz extends BaseBiz<Organization, Integer>{

	@Autowired
	private OrganizationDao organizationDao;
	
	public List<Organization> getAll(){
		String hql = "from Organization";
		return organizationDao.find(hql);
	}
}
