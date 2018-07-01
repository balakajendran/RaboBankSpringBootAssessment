package com.rabobank.cst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabobank.cst.entity.Account;
import com.rabobank.cst.entity.ErrorTransaction;
import com.rabobank.cst.entity.Transaction;
import com.rabobank.cst.repositories.AccountRepository;
import com.rabobank.cst.repositories.ErrorTransactionRepository;
import com.rabobank.cst.repositories.TransactionRepository;

/**
 * @author Bala
 *
 */
@Service
public class CustomerTransactionServiceImpl implements CustomerTransactionService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private ErrorTransactionRepository errortTransactionRepository;

	/* (non-Javadoc)
	 * @see com.rabobank.cst.service.CustomerTransactionService#saveAccount(com.rabobank.cst.entity.Account)
	 */
	@Override
	public Account saveAccount(Account account) {
		accountRepository.save(account);
		return account;
	}

	/* (non-Javadoc)
	 * @see com.rabobank.cst.service.CustomerTransactionService#getAccountByAccountNo(java.lang.String)
	 */
	@Override
	public Account getAccountByAccountNo(String accountNo) {
		final Account acc = accountRepository.findByAccountNo(accountNo);
		return acc;
	}

	/* (non-Javadoc)
	 * @see com.rabobank.cst.service.CustomerTransactionService#getTransactionByReferenceId(java.lang.Long)
	 */
	@Override
	public Transaction getTransactionByReferenceId(Long referenceId) {
		final Transaction trans = transactionRepository.findTransactionByReferenceId(referenceId);
		return trans;
	}

	/* (non-Javadoc)
	 * @see com.rabobank.cst.service.CustomerTransactionService#listAllErrorTransaction()
	 */
	@Override
	public List<ErrorTransaction> listAllErrorTransaction() {
		return errortTransactionRepository.findAll();
	}

}
