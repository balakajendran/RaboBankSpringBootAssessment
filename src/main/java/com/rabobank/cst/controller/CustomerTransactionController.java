package com.rabobank.cst.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rabobank.cst.dto.CustomerErrorTransaction;
import com.rabobank.cst.dto.CustomerTransactionDTO;
import com.rabobank.cst.entity.ErrorTransaction;
import com.rabobank.cst.service.CustomerTransactionService;

/**
 * @author Bala
 *
 */
@RestController
@RequestMapping("CST")
public class CustomerTransactionController {

	@Autowired
	CustomerTransactionService customerTransactionService;
	
	@CrossOrigin
	@RequestMapping(value = "/errorTransaction", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerErrorTransaction> listAllErrorTransactions() {
        List<ErrorTransaction> errorTransactions = customerTransactionService.listAllErrorTransaction();
        List<CustomerErrorTransaction> result = new ArrayList<>();
        if (!errorTransactions.isEmpty()) {
        	CustomerErrorTransaction trans = null;
        	for(ErrorTransaction errTrans:errorTransactions) {
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
        return result;
    }
}
