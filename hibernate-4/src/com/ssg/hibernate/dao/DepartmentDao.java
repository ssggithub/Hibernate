package com.ssg.hibernate.dao;

import org.hibernate.Session;

import com.ssg.hibernate.entities.Department;
import com.ssg.hibernate.utils.HibernateUtils;

public class DepartmentDao {

	public void save(Department dept) {
		// �ڲ���ȡ Session ����
		// ��ȡ�͵�ǰ�̰߳󶨵� Session ����
		// 1. ����Ҫ���ⲿ���� Session ����
		// 2. ��� DAO ����Ҳ����ʹ��һ������!
		Session session = HibernateUtils.getInstance().getSession();
		System.out.println(session.hashCode());
		session.save(dept);
	}

	/**
	 * ����Ҫ����һ�� Session ����, ����ζ����һ��(Service)��Ҫ��ȡ�� Session ����. ��˵����һ����Ҫ�� Hibernate
	 * �� API �������. ���Բ��Ƽ�ʹ�ô��ַ�ʽ.
	 */
	public void save(Session session, Department dept) {
		session.save(dept);
	}
}
