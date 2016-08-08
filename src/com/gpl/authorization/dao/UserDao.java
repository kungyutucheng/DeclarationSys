package com.gpl.authorization.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gpl.authorization.model.User;
import com.gpl.framework.base.dao.BaseDao;

@Component
public class UserDao extends BaseDao<User, Integer>{

	public boolean isUserExist(String account ,String password){
		String hql = "from User where account = '" + account + "' and password='" + password +"'";
		List<User> users = find(hql);
		if(users != null && users.size() > 0){
			return true;
		}
		return false;
		
	}
}
