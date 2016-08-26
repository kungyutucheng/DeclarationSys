package com.gpl.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateTest {

	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void beforeClass(){
		sessionFactory = new AnnotationConfiguration().configure("/spring/spring.xml").buildSessionFactory();
	}
	
	@Test
	public void testQuery(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from LoginLog where 1=1 result = ?");
		query.setParameter(0, 1);
		System.out.println(query.list().toString());
	}
}
