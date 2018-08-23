package com.accenture.basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Laptop {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lid;
	private String lbrand;
	private int cost;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLbrand() {
		return lbrand;
	}

	public void setLbrand(String lbrand) {
		this.lbrand = lbrand;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lbrand=" + lbrand + ", cost=" + cost + "]";
	}

}
