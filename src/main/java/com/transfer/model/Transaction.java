package com.transfer.model;

import java.math.BigDecimal;

/**
 * This is model to represent incoming Transfer Request
 *
 * @author Tanmay G
 *
 */
public class Transaction {
    private final String sourceAccountNo;
    private final String destinationAccountNo;
    private final BigDecimal amount;

    public Transaction(String sourceAccountNo, String destinationAccountNo, BigDecimal amount) {
        this.sourceAccountNo = sourceAccountNo;
        this.destinationAccountNo = destinationAccountNo;
        this.amount = amount;
    }

    public String getSourceAccountNo() {
        return sourceAccountNo;
    }

    public String getDestinationAccountNo() {
        return destinationAccountNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
