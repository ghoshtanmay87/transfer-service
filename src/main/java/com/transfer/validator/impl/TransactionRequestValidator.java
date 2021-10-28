package com.transfer.validator.impl;

import com.transfer.exception.AccountException;
import com.transfer.model.Transaction;
import com.transfer.validator.RequestValidator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * This is validator class for static validations of {@link Transaction}
 *
 * @author Tanmay G
 *
 */

@Component
public class TransactionRequestValidator implements RequestValidator<Transaction> {

    @Override
    public void validate(Transaction transaction) {
        if(transaction.getSourceAccountNo() == null ||
                "".equals(transaction.getSourceAccountNo().trim())){
            throw new AccountException("sourceAccountNo is empty");
        }
        if(transaction.getDestinationAccountNo() == null ||
                "".equals(transaction.getDestinationAccountNo().trim())){
            throw new AccountException("destinationAccountNo is empty");
        }
        if(transaction.getSourceAccountNo().equals(transaction.getDestinationAccountNo())){
            throw new AccountException("sourceAccountNo and destinationAccountNo are same");
        }
        if(transaction.getAmount().compareTo(new BigDecimal("0.00")) < 0){
            throw new AccountException("invalid transfer amount");
        }
    }
}
