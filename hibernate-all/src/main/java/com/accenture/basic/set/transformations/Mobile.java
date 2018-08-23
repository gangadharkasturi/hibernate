package com.accenture.basic.set.transformations;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mobile {
@Id 
private int mobileId;
private String mobileBrand;
private String mobileOS;
public int getMobileId() {
	return mobileId;
}
public void setMobileId(int mobileId) {
	this.mobileId = mobileId;
}
public String getMobileBrand() {
	return mobileBrand;
}
@Override
public String toString() {
	return "Mobile [mobileId=" + mobileId + ", mobileBrand=" + mobileBrand + ", mobileOS=" + mobileOS + "]";
}
public void setMobileBrand(String mobileBrand) {
	this.mobileBrand = mobileBrand;
}
public String getMobileOS() {
	return mobileOS;
}
public void setMobileOS(String mobileOS) {
	this.mobileOS = mobileOS;
}

}
