package de.telekom.sea7.inter.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.telekom.sea7.impl.model.TransactionImpl;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionImpl, Integer> {

}
