package com.gpl.framework.context;

import com.gpl.authorization.model.User;

public class UserContext {

	private static ThreadLocal<UserContext> threadLocal = new ThreadLocal<UserContext>();
	
	private User user;
	
	private UserContext(User user){
		this.user = user;
	}
	
	public static void setContext(User user){
		threadLocal.set(new UserContext(user));
	}
	
	public static UserContext getContext(){
		return threadLocal.get();
	}
	
	public User getUser(){
		return user;
	}
}
