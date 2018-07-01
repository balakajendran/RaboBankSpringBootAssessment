package com.rabobank.cst.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rabobank.cst.entity.Transaction;

/**
 * @author Bala
 *
 */
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	Transaction findTransactionByReferenceId(Long referenceId);

}
