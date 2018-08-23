package com.test.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table
@Entity
public class Sim {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	private String sBrand;
	@Transient
	private int sVoltage;

	@Override
	public String toString() {
		return "Sim [sid=" + sid + ", sBrand=" + sBrand + ", sVoltage=" + sVoltage + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getsBrand() {
		return sBrand;
	}

	public void setsBrand(String sBrand) {
		this.sBrand = sBrand;
	}

	public int getsVoltage() {
		return sVoltage;
	}

	public void setsVoltage(int sVoltage) {
		this.sVoltage = sVoltage;
	}
}
