package de.telekom.sea7.impl.repository;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Bic {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	@Column(unique=true)
//	@NotNull
	private String bic;
	private String institute;
	
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (obj instanceof Bic) {
			if (((Bic) obj).getBic().equals(getBic())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getBic());
	}
}
