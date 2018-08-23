package com.accenture.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.accenture.hibernate.Student;

public class MyHibernate {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class).configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		
		Laptop laptop = new Laptop();
		laptop.setLbrand("HP");
		laptop.setCost(0001000);
		session1.save(laptop);
		laptop.setLbrand("dell");
		Student student = new Student();
		student.setSname("Gangadhar");
		session1.save(student);		
		
		session1.getTransaction().commit();
	}
}
