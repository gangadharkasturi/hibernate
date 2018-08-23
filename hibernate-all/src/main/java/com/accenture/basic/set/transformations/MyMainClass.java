package com.accenture.basic.set.transformations;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

public class MyMainClass {
public static void main(String[] args) {
	Configuration configuration = new Configuration().addAnnotatedClass(Mobile.class).configure();
	SessionFactory factory = configuration.buildSessionFactory();
	Session session = factory.openSession();
	session.beginTransaction();
	/*Mobile mobile = new Mobile();
	mobile.setMobileBrand("aaa");
	mobile.setMobileOS("lt");
	session.save(mobile);
	session.getTransaction().commit();*/
	/*SQLQuery sqlQuery = session.createSQLQuery("select mobileBrand from Mobile");
	sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	List students = sqlQuery.list();
	for(Object obj : students)
	{
		Map map = (Map)obj;
		System.out.println(map.get("mobileBrand"));
	}
	session.getTransaction().commit();
	*/
	/*SQLQuery sqlQuery = session.createSQLQuery("select mobileBrand from Mobile");
	sqlQuery.setResultTransformer(Transformers.aliasToBean(Mobile.class));
	List<Mobile> mobiles = sqlQuery.list();
	for(Mobile m : mobiles){
		System.out.println(m);
	}*/
	
	/*Criteria criteria = session.createCriteria(Mobile.class).setProjection(Projections.property("mobileBrand"));
	criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); //this piece of code will not work
	List mobiles = criteria.list();
	for(Object obj : mobiles)
	{
		Map map = (Map)obj;
		System.out.println(map.get("mobileBrand"));
	}*/
	
	Criteria criteria = session.createCriteria(Mobile.class).setProjection(Projections.property("mobileBrand"));
	criteria.setResultTransformer(Transformers.aliasToBean(Mobile.class)); 
	List<Mobile> mobiles = criteria.list();
	for(Mobile obj : mobiles)
	{
		
		System.out.println(obj);
	}
}
}
