package com.accenture.hibernate.nativequery.namedquery;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHQL {
	public static void main(String[] args) {
		Configuration config = new Configuration().addAnnotatedClass(Student.class).configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("select sid,sname from Student");
		List<Object[]> objs = (List<Object[]>) query.list();
		for (Object obj[] : objs)
			System.out.println("sid:" + obj[0] + "\t" + "sname:" + obj[1]);

		session.getTransaction().commit();

		session.getTransaction().begin();
		Query q = session.createQuery("select max(sid) from Student");
		Object object = (Object) q.uniqueResult();
		Integer maxId = (Integer) q.uniqueResult();
		System.out.println("MaxId:" + maxId);
		System.out.println(object);
		Query q2 = session.createQuery("select max(sid) from Student where sid = :sid");
		q2.setParameter("sid", 11);
		Object o = (Object) q2.uniqueResult();
		System.out.println(o);

		SQLQuery sqlQuery = session.createSQLQuery("select * from Student");
		List<Object[]> obj = (List<Object[]>) sqlQuery.list();
		for (Object[] objec : obj) {
			System.out.println("sid:" + objec[0] + "\t" + "sname:" + objec[1]);
		}

		List students = sqlQuery.list();
		for (Object s : students) {
			System.out.println(s);
		}
		sqlQuery.addEntity(Student.class);
		List<Student> ss = sqlQuery.list();
		for (Student s : ss) {
			System.out.println(s);
		}

		session.getTransaction().commit();

		Session session2 = factory.openSession();
		session2.getTransaction().begin();
		SQLQuery sqlQuery2 = session2.createSQLQuery("select sid,sname from Student");
		List studentz = sqlQuery2.list();
		for (Object st : studentz)
		{
			
			System.out.println(st);
		}

		sqlQuery2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List studentss = sqlQuery2.list();
		for (Object oo : studentss)
		{
			Map m = (Map)oo;
			System.out.println("SID:"+m.get("sid")+"\t"+"SNAME:"+m.get("sname"));
		}
	}
}
