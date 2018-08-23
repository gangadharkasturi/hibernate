package com.gk.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Gangadhar Kasturi
 *
 */
public class MyHibernate {
	public static void main(String[] args) {
		/**
		 * loading the configuration from hibernate.cfg.xml and our entity class Student
		 * If you use default configuration file name as hibernate.cfg.xml then no need to specify it in configure method, if not you 
		 * need to specify. i.e. if your file name is myfile.cfg.xml then load as configure("myfile.cfg.xml");
		 * addAnnotatedClass is a replacement for <mapping> class in hibernate.cfg.xml.
		 */
		Configuration configuration = new Configuration().addAnnotatedClass(Student.class).configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		/**
		 * Every transaction in hibernate should satisfy ACID properties.So that you should start the transaction before saving it in db, and
		 * you should commit the transaction after saving in database.
		 */
		
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		

		Student student = new Student();
		student.setSname("Gangadhar");
		/**
		 * session.save(student) is equal to insert into query.
		 */
		session1.save(student);

		session1.getTransaction().commit();
	}
}
