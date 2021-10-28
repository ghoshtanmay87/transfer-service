package com.transfer.transferservice;

import com.transfer.dao.AccountDao;
import com.transfer.model.Account;
import com.transfer.model.Transaction;
import com.transfer.model.TransferData;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransferServiceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private AccountDao accountDao;

	@Test
	public void testInvokeAPISuccess() {
		String sourceAccountNo = "A10000";
		String destinationAccountNo = "B20000";
		BigDecimal transferAmount = new BigDecimal("100.00");

		Transaction request = new Transaction(sourceAccountNo, destinationAccountNo, transferAmount);
		TransferData expected = new TransferData().setSourceAccountNo(sourceAccountNo).
				setDestinationAccountNo(destinationAccountNo).
				setAmount(transferAmount).
				setTransactionStatus(TransferData.TransactionStatus.SUCCESS);

		Account sourceAccountBefore = accountDao.getByAccountNo(sourceAccountNo);
		Account destinationAccountBefore = accountDao.getByAccountNo(destinationAccountNo);

		HttpEntity<Transaction> requestEntity = new HttpEntity<>(request);
		ResponseEntity<TransferData> response = this.restTemplate.exchange("/api/transfer", HttpMethod.POST,
				requestEntity, TransferData.class);

		// Test non null API responses
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBody());
		Assert.assertNotNull(response.getHeaders());

		// Test whether response contains appropriate data
		Assert.assertEquals(expected.getSourceAccountNo(), response.getBody().getSourceAccountNo());
		Assert.assertEquals(expected.getDestinationAccountNo(), response.getBody().getDestinationAccountNo());
		Assert.assertEquals(expected.getAmount(), response.getBody().getAmount());
		Assert.assertEquals(expected.getTransactionStatus(), response.getBody().getTransactionStatus());

		// Check balance in source and destination account in in-memory DB post transfer
		Account sourceAccountAfter = accountDao.getByAccountNo(sourceAccountNo);
		Account destinationAccountAfter = accountDao.getByAccountNo(destinationAccountNo);
		Assert.assertEquals(sourceAccountBefore.getBalance().subtract(transferAmount), sourceAccountAfter.getBalance());
		Assert.assertEquals(destinationAccountBefore.getBalance().add(transferAmount), destinationAccountAfter.getBalance());
	}

}
