package com.rabobank.cst.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabobank.cst.entity.Account;
import com.rabobank.cst.entity.ErrorTransaction;
import com.rabobank.cst.entity.Transaction;
import com.rabobank.cst.repositories.AccountRepository;
import com.rabobank.cst.repositories.ErrorTransactionRepository;
import com.rabobank.cst.repositories.TransactionRepository;
import com.rabobank.cst.service.CustomerTransactionService;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTransactionServiceImplTest {

	@MockBean
	private AccountRepository accountRepository;

	@MockBean
	private TransactionRepository transactionRepository;

	@MockBean
	private ErrorTransactionRepository errortTransactionRepository;
	
	@Autowired
	CustomerTransactionService customerTransactionService;
	
	@Test
	public void testSaveAccount(){
		Account acc = new Account();
		acc.setAccountId(Long.parseLong("1"));
		acc.setAccountNo("SNUPTEST0001");
		Transaction trans = new Transaction();
		acc.addTransaction((Transaction) trans);
		trans.setReferenceId(Long.valueOf(12345));
		trans.setDescription("Test Data");
		trans.setStartBalance(Float.parseFloat("10.15"));
		trans.setMutation(Float.parseFloat("-5.15"));
		trans.setEndBalance(Float.parseFloat("5"));
		trans.setAccount(acc);
		Mockito.when(accountRepository.save(acc)).thenReturn(acc);
		assertThat(customerTransactionService.saveAccount(acc)).isEqualTo(acc);
		
		Account acc1 = new Account();
		acc1.setAccountId(Long.parseLong("2"));
		acc1.setAccountNo("SNUPTEST0002");
		ErrorTransaction errTrans = new ErrorTransaction();
		acc1.addErrorTransaction((ErrorTransaction) errTrans);
		errTrans.setReferenceId(Long.valueOf(12345));
		errTrans.setDescription("Test Data");
		errTrans.setStartBalance(Float.parseFloat("10.15"));
		errTrans.setMutation(Float.parseFloat("-5.15"));
		errTrans.setEndBalance(Float.parseFloat("5"));
		errTrans.setAccount(acc1);
		Mockito.when(accountRepository.save(acc1)).thenReturn(acc1);
		assertThat(customerTransactionService.saveAccount(acc1)).isEqualTo(acc1);
	}
	
	@Test
	public void testGetAccountByAccountNo(){
		Account acc = new Account();
		acc.setAccountId(Long.parseLong("1"));
		acc.setAccountNo("SNUPTEST0001");
		Transaction trans = new Transaction();
		acc.addTransaction((Transaction) trans);
		trans.setReferenceId(Long.valueOf(12345));
		trans.setDescription("Test Data");
		trans.setStartBalance(Float.parseFloat("10.15"));
		trans.setMutation(Float.parseFloat("-5.15"));
		trans.setEndBalance(Float.parseFloat("5"));
		trans.setAccount(acc);
		Mockito.when(accountRepository.findByAccountNo("SNUPTEST0001")).thenReturn(acc);
		assertThat(customerTransactionService.getAccountByAccountNo("SNUPTEST0001")).isEqualTo(acc);		
	}
	
	@Test
	public void testGetTransactionByReferenceId(){
		Account acc = new Account();
		acc.setAccountId(Long.parseLong("1"));
		acc.setAccountNo("SNUPTEST0001");
		Transaction trans = new Transaction();
		acc.addTransaction((Transaction) trans);
		trans.setReferenceId(Long.valueOf(12345));
		trans.setDescription("Test Data");
		trans.setStartBalance(Float.parseFloat("10.15"));
		trans.setMutation(Float.parseFloat("-5.15"));
		trans.setEndBalance(Float.parseFloat("5"));
		trans.setAccount(acc);
		Mockito.when(transactionRepository.findTransactionByReferenceId(Long.parseLong("1"))).thenReturn(trans);
		assertThat(customerTransactionService.getTransactionByReferenceId(1L)).isEqualTo(trans);		
	}
	
	@Test
	public void testListAllErrorTransaction() {
		Account acc1 = new Account();
		acc1.setAccountId(Long.parseLong("2"));
		acc1.setAccountNo("SNUPTEST0002");
		ErrorTransaction errTrans = new ErrorTransaction();
		acc1.addErrorTransaction((ErrorTransaction) errTrans);
		errTrans.setReferenceId(Long.valueOf(12345));
		errTrans.setDescription("Test Data");
		errTrans.setStartBalance(Float.parseFloat("10.15"));
		errTrans.setMutation(Float.parseFloat("-5.15"));
		errTrans.setEndBalance(Float.parseFloat("5"));
		errTrans.setAccount(acc1);
		List<ErrorTransaction> errTransList = new ArrayList<>();
		errTransList.add(errTrans);
		
		Mockito.when(errortTransactionRepository.findAll()).thenReturn(errTransList);
		assertThat(customerTransactionService.listAllErrorTransaction()).isEqualTo(errTransList);
	}
	
	
}
