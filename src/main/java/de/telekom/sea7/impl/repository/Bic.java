package de.telekom.sea7.impl.repository;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Bic {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ID;
	private String bic;
	private String institute;
	
	@OneToMany(mappedBy="bic")
	@JsonManagedReference
	private List<Iban> ibans;
	
	public List<Iban> getIbans() {
		return ibans;
	}

	public void setIbans(List<Iban> ibans) {
		this.ibans = ibans;
	}

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
