package de.telekom.sea7.impl.repository;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Iban {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true)
//	@NotNull
	private String iban;
	
//	@NotNull
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="bic_id")
	private Bic bic;

	public long getId() {
		return id;
	}

	public String getIban() {
		return iban;
	}

	public Bic getBic() {
		return bic;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public void setBic(Bic bic) {
		this.bic = bic;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (obj instanceof Iban) {
			if (((Iban) obj).getIban().equals(getIban())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getIban());
	}
}
