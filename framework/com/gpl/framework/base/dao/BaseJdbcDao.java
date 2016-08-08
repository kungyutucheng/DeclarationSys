package com.gpl.framework.base.dao;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BaseJdbcDao extends JdbcTemplate{

	private static final Log log = LogFactory.getLog(BaseJdbcDao.class);
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}
	
	
}
