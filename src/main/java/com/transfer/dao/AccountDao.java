package com.transfer.dao;

import com.transfer.model.Account;

/**
 * This is AccountDao interface to access accounts from database
 *
 * @author Tanmay G
 *
 */
public interface AccountDao {
    /**
     * Fetches the Account using accountNo
     *
     * @param accountNo account number to be searched
     * @return {@link Account}
     */
    public Account getByAccountNo(String accountNo);

    /**
     * Stores updated Account
     *
     * @param account {@link Account}
     */
    public void saveAccount(Account account);
}
