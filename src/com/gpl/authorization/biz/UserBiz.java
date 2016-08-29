package com.gpl.authorization.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpl.authorization.dao.ModuleDao;
import com.gpl.authorization.dao.UserDao;
import com.gpl.authorization.model.Module;
import com.gpl.authorization.model.User;
import com.gpl.framework.annotation.SystemBizLog;
import com.gpl.framework.base.biz.BaseBiz;

@Service
public class UserBiz extends BaseBiz<User, Integer>{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModuleDao moduleDao;
	
	/**
	 * 根据账户和密码验证用户是否合法
	 * @param account
	 * @param password
	 * @return
	 */
	public boolean isUserExist(String account ,String password){
		String hql = "from User where account = '" + account + "' and password='" + password +"'";
		List<User> users = userDao.find(hql);
		if(users != null && users.size() > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 获取对应账户下的模块数据
	 * @param account
	 * @return
	 */
	@SystemBizLog(desc = "获取对应账户下的模块数据")
	public List<Module> getModules(String account){
		String hql = "from Module m where m.id in "
				+ "(select rm.mid from RoleModule rm where rm.rname ="
				+ "(select u.rname from User u where u.account='"+account+"'))";
		return moduleDao.find(hql);
	}
	

}
