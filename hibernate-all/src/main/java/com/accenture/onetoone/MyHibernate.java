package com.accenture.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyHibernate {
	public static void main(String[] args) {

		UserDetails userDetails = new UserDetails();
		userDetails.setUserName("GANGADHAR");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("MARUTHI SUZUKI");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("FORD");

		userDetails.setVehicle(vehicle);
		
		Configuration configuration = new Configuration().addAnnotatedClass(Vehicle.class)
				.addAnnotatedClass(UserDetails.class).configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(userDetails);
		session.save(vehicle);
		session.getTransaction().commit();

	}
}
