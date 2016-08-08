package com.gpl.authorization.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.authorization.dao.UserDao;
import com.gpl.authorization.model.User;
import com.gpl.framework.base.biz.BaseBiz;

@Service
public class UserBiz extends BaseBiz<User, Integer>{
	
	@Autowired
	private UserDao userDao;
	public boolean isUserExist(String account ,String password){
		return userDao.isUserExist(account, password);
	}

}
