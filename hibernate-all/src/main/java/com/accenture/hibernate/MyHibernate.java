package com.accenture.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyHibernate {
	public static void main(String[] args) {
		// Student student = new Student();
		// student.setSid(1);
		// student.setSname("nani");
		Configuration configuration = new Configuration().addAnnotatedClass(Student.class).configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Student student1 = (Student) session1.get(Student.class, 1);
		System.out.println(student1.toString());
		session1.getTransaction().commit();
		session1.close();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Student student2 = (Student) session2.get(Student.class, 1);
		System.out.println(student2.toString());
		session2.getTransaction().commit();
		session2.close();
	}
}
