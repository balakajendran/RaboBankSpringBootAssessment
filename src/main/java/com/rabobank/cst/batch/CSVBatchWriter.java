package com.rabobank.cst.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.rabobank.cst.dto.CustomerTransactionDTO;

/**
 * @author Bala
 *
 */
public class CSVBatchWriter implements ItemWriter<CustomerTransactionDTO> {

	@Autowired
	public JmsTemplate jmsTemplate;

	
	@Override
	public void write(List<? extends CustomerTransactionDTO> transactions) throws Exception {
		if (transactions.size() > 0) {
			for (final CustomerTransactionDTO transaction : transactions) {
				jmsTemplate.convertAndSend("customerTransactionQueue", transaction);
			}

		}

	}

}
