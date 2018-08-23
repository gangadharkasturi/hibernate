package com.test.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Table
@Entity
public class Mobile {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int mid;
	private String brand;
	private String os;
	@OneToOne
	@JoinColumn(name="SIM_FK")
	private Sim sim;

	@Override
	public String toString() {
		return "Mobile [mid=" + mid + ", brand=" + brand + ", os=" + os + "]";
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Sim getSim() {
		return sim;
	}

	public void setSim(Sim sim) {
		this.sim = sim;
	}
}
