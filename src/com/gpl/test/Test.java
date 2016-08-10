package com.gpl.test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gpl.authorization.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:/spring/spring.xml")
public class Test {

	@Autowired
	private UserController userController;
	

	@org.junit.Test
	public void test(){
	}
}
