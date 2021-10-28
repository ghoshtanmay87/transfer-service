package com.transfer.service;

import com.transfer.model.Account;

/**
 * This is AccountService interface to access accounts
 *
 * @author Tanmay G
 *
 */
public interface AccountService {
    /**
     * Fetches the Account using accountNo
     *
     * @param accountNo transfer number be searched
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
