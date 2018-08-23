package com.accenture.hibernate.nativequery.namedquery;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

public class MyHibernate {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Configuration configuration = new Configuration().addAnnotatedClass(Student.class).configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(Student.STUDENT_BY_ID).setParameter("sid", 12);
		List<Student> students = (List<Student>) query.list();
		for (Student s : students) {
			System.out.println(s);
		}
		Query query2 = session.getNamedQuery(Student.STUDENT_BY_ID_SQL).setInteger(0, 11);
		Student student2 = (Student) query2.uniqueResult();
		System.out.println(student2);

		Criteria criteria = session.createCriteria(Student.class)
				// .setProjection(Projections.property("sid"))
				// .setProjection(Projections.max("sid"));
				.addOrder(org.hibernate.criterion.Order.desc("sid"));
		List<Student> st = (List<Student>) criteria.list();
		for (Student ss : st) {
			System.out.println(ss);
		}

		Student stu = new Student();
		stu.setSid(11);
		stu.setSname("gk");
		Example example = Example.create(stu); 
		Criteria criteria2 = session.createCriteria(Student.class);
		// .setProjection(Projections.property("sid"))
		// .setProjection(Projections.max("sid"));
		// .addOrder(org.hibernate.criterion.Order.desc("sid"));
		criteria2.add(example);
		List<Student> studentz = (List<Student>) criteria2.list();
		System.out.println("by example");
		for (Student ss : studentz) {
			System.out.println(ss);
		}
//there are 2 rules like , if there any primary key poperty it ignores that condition and if null is also thre in the example property it ignores
	
	
		Student stud = new Student();
		stud.setSid(11);
		stud.setSname("%gk%");
		Example examplee = Example.create(stud).enableLike(); //enables like operation
		//Example examplee = Example.create(stud).excludeProperty("sid");//to exclude the property from criteria
		Criteria criteria3 = session.createCriteria(Student.class);
		// .setProjection(Projections.property("sid"))
		// .setProjection(Projections.max("sid"));
		// .addOrder(org.hibernate.criterion.Order.desc("sid"));
		criteria3.add(examplee);
		List<Student> studentzz = (List<Student>) criteria3.list();
		System.out.println("by example");
		for (Student ss : studentzz) {
			System.out.println(ss);
		}
	
	}
}
