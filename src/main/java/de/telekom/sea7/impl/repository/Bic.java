package de.telekom.sea7.impl.repository;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Bic {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	@Column(unique=true)
	private String bic;
	private String institute;
	
//	@OneToMany(mappedBy="bic")
//	@JsonIgnore
//	private List<Iban> ibans;
	
//	public List<Iban> getIbans() {
//		return ibans;
//	}
//
//	public void setIbans(List<Iban> ibans) {
//		this.ibans = ibans;
//	}

	public long getId() {
		return id;
	}
	
	public String getBic() {
		return bic;
	}
	
	public String getInstitute() {
		return institute;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setBic(String bic) {
		this.bic = bic;
	}
	
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	
	
}
