package com.rabobank.cst.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rabobank.cst.entity.ErrorTransaction;

/**
 * @author Bala
 *
 */
public interface ErrorTransactionRepository extends CrudRepository<ErrorTransaction, Long> {

	@Override
	List<ErrorTransaction> findAll();

}
