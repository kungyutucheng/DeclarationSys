package com.gpl.test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gpl.authorization.controller.UserController;
import com.gpl.module.base.controller.EnterpriseController;
import com.gpl.module.base.controller.OrganizationController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:/spring/spring.xml")
public class Test {

	@Autowired
	private UserController userController;
	
	@Autowired
	private EnterpriseController enterpriseController;
	
	@Autowired
	private OrganizationController organizationController;

	@org.junit.Test
	public void test(){
		System.out.println(enterpriseController.getAll());
	}
}
