package de.telekom.sea7.impl.repository;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Iban {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true)
	private String iban;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bic_id")
	private Bic bic;
	
//	@OneToMany(mappedBy="iban")
//	@JsonIgnore
//	private List<Transaction> transactions;

	public long getId() {
		return id;
	}

	public String getIban() {
		return iban;
	}

	public Bic getBic() {
		return bic;
	}

//	public List<Transaction> getTransactions() {
//		return transactions;
//	}

	public void setId(long id) {
		this.id = id;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public void setBic(Bic bic) {
		this.bic = bic;
	}

//	public void setTransactions(List<Transaction> transactions) {
//		this.transactions = transactions;
//	}
}
