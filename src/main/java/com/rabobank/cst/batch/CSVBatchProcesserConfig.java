package com.rabobank.cst.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.rabobank.cst.dto.CustomerTransactionDTO;

/**
 * @author Bala
 *
 */
@Configuration
@EnableBatchProcessing
public class CSVBatchProcesserConfig {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	
	@Bean
	public FlatFileItemReader<CustomerTransactionDTO> csvCustomerTransactionReader() {
		final FlatFileItemReader<CustomerTransactionDTO> reader = new FlatFileItemReader<CustomerTransactionDTO>();
		reader.setResource(new ClassPathResource("templates/records.csv"));
		reader.setLinesToSkip(1);
		reader.setLineMapper(new DefaultLineMapper<CustomerTransactionDTO>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "referenceId", "accountNo", "description", "startBalance", "mutation",
								"endBalance" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<CustomerTransactionDTO>() {
					{
						setTargetType(CustomerTransactionDTO.class);
					}
				});
			}
		});
		return reader;
	}

	@Bean
	ItemProcessor<CustomerTransactionDTO, CustomerTransactionDTO> csvCustomerTransactionProcessor() {
		return new CSVBatchProcesser();
	}

	@Bean
	public ItemWriter<? super CustomerTransactionDTO> csvCustomerTransactionWriter() {
		return new CSVBatchWriter();
	}

	// end reader, writer, and processor

	// begin job info
	@Bean
	public Step csvFileToJMSStep() {
		return stepBuilderFactory.get("csvFileToJMSStep").<CustomerTransactionDTO, CustomerTransactionDTO>chunk(1)
				.reader(csvCustomerTransactionReader()).processor(csvCustomerTransactionProcessor())
				.writer(csvCustomerTransactionWriter()).build();
	}

	@Bean
	public Job csvFileToJMSJob() {
		return jobBuilderFactory.get("csvFileToJMSJob").incrementer(new RunIdIncrementer()).flow(csvFileToJMSStep())
				.end().build();
	}
	// end job info
}