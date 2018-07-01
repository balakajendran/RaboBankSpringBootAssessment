package com.rabobank.cst.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.rabobank.cst.dto.CustomerTransactionDTO;
import com.rabobank.cst.entity.Account;
import com.rabobank.cst.entity.BaseTransaction;
import com.rabobank.cst.entity.ErrorTransaction;
import com.rabobank.cst.entity.Transaction;
import com.rabobank.cst.service.CustomerTransactionService;
import com.rabobank.cst.utility.ValidationUtil;

/**
 * @author Bala
 *
 */
@Component
public class CustomerTransactionJMSReceiver {

	@Autowired
	private CustomerTransactionService customerTransactionService;

	
	@JmsListener(destination = "customerTransactionQueue", containerFactory = "jmsFactory")
	public void receiveMessage(CustomerTransactionDTO msg) {
		String errorDetail = null;

		Account acc = customerTransactionService.getAccountByAccountNo(msg.getAccountNo());
		if (null == acc) {
			acc = new Account();
			acc.setAccountNo(msg.getAccountNo());
		}
		if (null != msg.getRefereceId()) {
			final Transaction transaction = customerTransactionService
					.getTransactionByReferenceId(Long.valueOf(msg.getRefereceId()));
			if (null != transaction) {
				errorDetail = "Duplicate Transaction entry";
			}
		} else {
			errorDetail = "Transaction Reference is Empty";
		}

		if (null == errorDetail) {
			errorDetail = ValidationUtil.validateTransaction(msg);
		}

		BaseTransaction trans = null;
		if (null == errorDetail) {
			trans = new Transaction();
			acc.addTransaction((Transaction) trans);
		} else {
			trans = new ErrorTransaction();
			((ErrorTransaction) trans).setErrorDetails(errorDetail);
			trans.setAccount(acc);
			acc.addErrorTransaction((ErrorTransaction) trans);
		}

		trans.setReferenceId(Long.valueOf(msg.getRefereceId()));
		trans.setDescription(msg.getDescription());
		trans.setStartBalance(Float.parseFloat(msg.getStartBalance()));
		trans.setMutation(Float.parseFloat(msg.getMutation()));
		trans.setEndBalance(Float.parseFloat(msg.getEndBalance()));
		trans.setAccount(acc);

		acc = customerTransactionService.saveAccount(acc);

	}
}
