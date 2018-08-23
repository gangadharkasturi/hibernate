package com.accenture.projections;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.accenture.hibernate.Student;

public class MyHibernate {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().addAnnotatedClass(Student.class).configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Student> students = session.createCriteria(Student.class).add(Restrictions.between("sid", 10, 25))
				.add(Restrictions.like("sname", "%gk%")).list();
		for (Student s : students) {
			System.out.println(s);
		}
	}
}
