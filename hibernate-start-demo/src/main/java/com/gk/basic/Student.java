package com.gk.basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Gangadhar Kasturi
 *
 */

/**
 * 
 * You can give name to your entity/table by using "name" property.
 * eg. @Table(name="STUDENT_TABLE"),also you can give names to each coloum i.e. variables in the class
 *
 */
@Table
@Entity
public class Student {
	@Id //defining SID as a primary key and automatically generated by hibernate
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	private String sname;


	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}
}
