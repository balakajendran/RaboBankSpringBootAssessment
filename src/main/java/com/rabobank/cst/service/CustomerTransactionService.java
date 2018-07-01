package com.rabobank.cst.service;

import java.util.List;

import com.rabobank.cst.entity.Account;
import com.rabobank.cst.entity.ErrorTransaction;
import com.rabobank.cst.entity.Transaction;

/**
 * @author Bala
 *
 */
public interface CustomerTransactionService {

	Account getAccountByAccountNo(String accountNo);

	Transaction getTransactionByReferenceId(Long referenceId);

	List<ErrorTransaction> listAllErrorTransaction();

	Account saveAccount(Account account);

}
