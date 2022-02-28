package de.telekom.sea7.inter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.telekom.sea7.impl.repository.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
