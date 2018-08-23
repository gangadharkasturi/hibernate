package com.accenture.hibernate.nativequery.namedquery;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(name=Student.STUDENT_BY_ID,query=Student.STUDENT_BY_ID_QUERY)
@NamedNativeQuery(name = Student.STUDENT_BY_ID_SQL,query=Student.STUDENT_BY_ID_SQL_QUERY,resultClass=Student.class)
public class Student {
	static final String STUDENT_BY_ID = "STUDENT_BY_ID";
	static final String STUDENT_BY_ID_QUERY = "from Student where sid = :sid";
	static final String STUDENT_BY_ID_SQL="STUDENT_BY_ID_SQL";
	static final String STUDENT_BY_ID_SQL_QUERY ="SELECT * FROM Student where sid = ?";
	@Id
	private int sid;
	private String sname;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}
