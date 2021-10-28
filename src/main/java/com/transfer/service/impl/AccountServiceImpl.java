package com.transfer.service.impl;

import com.transfer.dao.AccountDao;
import com.transfer.exception.AccountException;
import com.transfer.exception.TransactionConflictException;
import com.transfer.exception.TransferServiceException;
import com.transfer.model.Account;
import com.transfer.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is AccountService implementation to access accounts
 *
 * @author Tanmay G
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    @Override
    public Account getByAccountNo(String accountNo){
        try{
            return accountDao.getByAccountNo(accountNo);
        }
        catch (EmptyResultDataAccessException ex){
            throw new AccountException("Account " + accountNo + " does not exist", ex);
        }
        catch(DataAccessException ex){
            throw new TransferServiceException("Error accessing Account data", ex);
        }
    }

    @Override
    @Transactional
    public void saveAccount(Account account){
        try{
            accountDao.saveAccount(account);
        }
        catch(OptimisticLockingFailureException ex){
            throw new TransactionConflictException("Balance for Account " + account.getAccountNo() + " updated " +
                    "while carrying out this transaction, please retry", ex);
        }
        catch(DataAccessException ex){
            throw new TransferServiceException("Error saving Account data", ex);
        }
    }
}
