package com.ssg.hibernate.helloworld;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void test() {
		System.out.println("test starting test starting...");

		// 1.创建sessionFactory对象
		SessionFactory sessionFactory = null;

		// 2.创建Configuration对象，对应 hibernate 的基本配置信息和 对象关系映射信息
		Configuration configuration = new Configuration().configure();

		// 3.创建ServiceRegistry对象:hibernate 4.x 新添加的对象
		// hibernate 的任何配置和服务都需要在该对象中注册后才能有效.
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		//4.创建session对象
		Session session = sessionFactory.openSession();
		
		//5.开启事务
		Transaction transaction = session.beginTransaction();
		
		//6.执行保存操作
		News news = new News("hibernate-1", "ssg", new Date(new java.util.Date().getTime()));
		session.save(news);
		
		//7.提交事务
		transaction.commit();
		
		session.close();
		sessionFactory.close();
		
		
	}
}
