package com.ssg.hibernate.one2one.primary;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testGet2() {
		// �ڲ�ѯû�������ʵ�����ʱ, ʹ�õ��������Ӳ�ѯ, һ����ѯ��������Ķ���
		// ���Ѿ����г�ʼ��.
		Manager mgr = (Manager) session.get(Manager.class, 1);
		System.out.println(mgr.getMgrName());
		System.out.println(mgr.getDept().getDeptName());
	}

	@Test
	public void testGet() {
		// 1. Ĭ������¶Թ�������ʹ��������
		Department dept = (Department) session.get(Department.class, 1);
		System.out.println(dept.getDeptName());

		// 2. ���Ի�����������쳣������. ��.
		Manager mgr = dept.getMgr();
		System.out.println(mgr.getMgrName());
	}

	@Test
	public void testSave() {

		Department department = new Department();
		department.setDeptName("DEPT-DD");

		Manager manager = new Manager();
		manager.setMgrName("MGR-DD");

		// �趨������ϵ
		manager.setDept(department);
		department.setMgr(manager);

		// �������
		// �Ȳ�����һ���������ж���� UPDATE
		session.save(department);
		session.save(manager);

	}

}
