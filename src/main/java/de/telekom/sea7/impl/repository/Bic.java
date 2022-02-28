package de.telekom.sea7.impl.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bic {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ID;
	private String bic;
	private String institute;
	
	public int getID() {
		return ID;
	}
	
	public String getBic() {
		return bic;
	}
	
	public String getInstitute() {
		return institute;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public void setBic(String bic) {
		this.bic = bic;
	}
	
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	
	
}
