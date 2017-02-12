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

		// 1.����sessionFactory����
		SessionFactory sessionFactory = null;

		// 2.����Configuration���󣬶�Ӧ hibernate �Ļ���������Ϣ�� �����ϵӳ����Ϣ
		Configuration configuration = new Configuration().configure();

		// 3.����ServiceRegistry����:hibernate 4.x ����ӵĶ���
		// hibernate ���κ����úͷ�����Ҫ�ڸö�����ע��������Ч.
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		//4.����session����
		Session session = sessionFactory.openSession();
		
		//5.��������
		Transaction transaction = session.beginTransaction();
		
		//6.ִ�б������
		News news = new News("hibernate-1", "ssg", new Date(new java.util.Date().getTime()));
		session.save(news);
		
		//7.�ύ����
		transaction.commit();
		
		session.close();
		sessionFactory.close();
		
		
	}
}
