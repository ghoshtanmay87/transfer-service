package com.transfer.model;

import java.math.BigDecimal;

/**
 * This is model to represent an Account
 *
 * @author Tanmay G
 *
 */
public class Account {
    private final String accountNo;
    private BigDecimal balance;
    private String accountName;
    private long version;

    public Account(String accountNo, BigDecimal balance, String accountName, long version) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.accountName = accountName;
        this.version = version;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
