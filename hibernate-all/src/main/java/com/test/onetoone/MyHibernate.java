package com.test.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyHibernate {
@SuppressWarnings("deprecation")
public static void main(String[] args) {
	
	/*Mobile mobile = new Mobile();
	mobile.setBrand("lenovo");
	mobile.setOs("android");
	
	
	Sim sim = new Sim();
	sim.setsBrand("airtel");
	sim.setsVoltage(5);
	
	mobile.setSim(sim);*/
	
	
	Configuration configuration = new Configuration().addAnnotatedClass(Mobile.class).addAnnotatedClass(Sim.class).configure();
	SessionFactory sessionFactroy = configuration.buildSessionFactory();
	Session session = sessionFactroy.openSession();
	session.beginTransaction();
	
	/*session.save(mobile);
	session.save(sim);*/
	
	Mobile mobile = (Mobile)session.get(Mobile.class, 1);
	System.out.println(mobile);
	
	session.getTransaction().commit();
	session.close();
	
	Session session2 = sessionFactroy.openSession();
	session2.beginTransaction();
	
	Mobile mobile2 = (Mobile)session2.get(Mobile.class, 1);
	System.out.println(mobile2);
	
	session2.getTransaction().commit();
	session2.close();
	
	
	
	
}
}
