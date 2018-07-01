package com.rabobank.cst.test.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabobank.cst.controller.CustomerTransactionController;
import com.rabobank.cst.dto.CustomerErrorTransaction;
import com.rabobank.cst.entity.Account;
import com.rabobank.cst.entity.ErrorTransaction;
import com.rabobank.cst.service.CustomerTransactionService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerTransactionController.class, secure = false)
public class CustomerTransactionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerTransactionService customerTransactionService;

	@Test
	public void testListAllErrorTransactions() throws Exception {
		List<ErrorTransaction> errorTransaction = new ArrayList<ErrorTransaction>();
		ErrorTransaction err = new ErrorTransaction();
		err.setErrorTransId((long) 1);
		err.setReferenceId((long) 12334);
		err.setDescription("Test data");
		err.setStartBalance((float) 10.11);
		err.setMutation((float) 1.11);
		err.setEndBalance((float) 113.11);
		Account acc = new Account();
		acc.setAccountId((long) 1);
		acc.setAccountNo("SNUTEST00001");
		err.setAccount(acc);

		Mockito.when(customerTransactionService.listAllErrorTransaction()).thenReturn(errorTransaction);
		List<CustomerErrorTransaction> result= new ArrayList<CustomerErrorTransaction>();
		CustomerErrorTransaction trans = null;
		if (!errorTransaction.isEmpty()) {
			for (ErrorTransaction errTrans : errorTransaction) {
				trans = new CustomerErrorTransaction();
				trans.setReferenceId(errTrans.getReferenceId());
				trans.setAccountNo(errTrans.getAccount().getAccountNo());
				trans.setDescription(errTrans.getDescription());
				trans.setStartBalance(errTrans.getStartBalance());
				trans.setMutation(errTrans.getMutation());
				trans.setEndBalance(errTrans.getEndBalance());
				trans.setErrorDetails(errTrans.getErrorDetails());
				result.add(trans);
			}
		}
		String URI = "/CST/errorTransaction";
		RequestBuilder reqbuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(reqbuilder).andReturn();
		String inputJson = this.mapToJson(result);
		String outputJson = mvcResult.getResponse().getContentAsString();
		assertThat(outputJson).isEqualTo(inputJson);

	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objMap = new ObjectMapper();
		return objMap.writeValueAsString(object);
	}
}
