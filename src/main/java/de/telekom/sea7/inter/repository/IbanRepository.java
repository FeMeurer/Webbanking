package de.telekom.sea7.inter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.telekom.sea7.impl.repository.Iban;

public interface IbanRepository extends JpaRepository<Iban, Integer> {

}