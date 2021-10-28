package com.transfer.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * This is model to represent Transfer output data from the API
 *
 * @author Tanmay G
 *
 */
public class TransferData {
    private String transactionId;
    private String sourceAccountNo;
    private String destinationAccountNo;
    private BigDecimal amount;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date transactionTime;
    private TransactionStatus transactionStatus;

    public String getTransactionId() {
        return transactionId;
    }

    public TransferData setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getSourceAccountNo() {
        return sourceAccountNo;
    }

    public TransferData setSourceAccountNo(String sourceAccountNo) {
        this.sourceAccountNo = sourceAccountNo;
        return this;
    }

    public String getDestinationAccountNo() {
        return destinationAccountNo;
    }

    public TransferData setDestinationAccountNo(String destinationAccountNo) {
        this.destinationAccountNo = destinationAccountNo;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransferData setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public TransferData setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
        return this;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public TransferData setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public enum TransactionStatus{
        SUCCESS,
        FAILED
    }
}
