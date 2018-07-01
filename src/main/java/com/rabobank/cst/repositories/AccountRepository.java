package com.rabobank.cst.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rabobank.cst.entity.Account;

/**
 * @author Bala
 *
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

	Account findByAccountNo(String accountNo);
}
