package com.rabobank.cst.batch;


import org.springframework.batch.item.ItemProcessor;

import com.rabobank.cst.dto.CustomerTransactionDTO;

/**
 * @author Bala
 *
 */
public class CSVBatchProcesser implements ItemProcessor<CustomerTransactionDTO, CustomerTransactionDTO> {

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
	 */
	@Override
	public CustomerTransactionDTO process(final CustomerTransactionDTO cusTransDTO) throws Exception {
		final CustomerTransactionDTO cusTranDto = new CustomerTransactionDTO();
		cusTranDto.setRefereceId(cusTransDTO.getRefereceId());
		cusTranDto.setAccountNo(cusTransDTO.getAccountNo());
		cusTranDto.setDescription(cusTransDTO.getDescription());
		cusTranDto.setStartBalance(cusTransDTO.getStartBalance());
		cusTranDto.setMutation(cusTransDTO.getMutation());
		cusTranDto.setEndBalance(cusTransDTO.getEndBalance());
		return cusTranDto;
	}
}
