package com.transfer.dao.impl;

import com.transfer.dao.AccountDao;
import com.transfer.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This is AccountDao implementation to access accounts from database
 *
 * @author Tanmay G
 *
 */
@Repository
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Autowired
    public AccountDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Account getByAccountNo(String accountNo){
        String query = "select account_no, account_name, balance, version from account where account_no = ?";
        return getJdbcTemplate().queryForObject(query, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Account(rs.getString("account_no"), rs.getBigDecimal("balance"),
                        rs.getString("account_name"), rs.getLong("version"));
            }
        }, new Object[]{accountNo});
    }

    @Override
    public void saveAccount(Account account) {
        String query = "update account set balance = ?, version = ? where account_no = ? and version = ?";
        int updateCount = getJdbcTemplate().update(query, new Object[]{account.getBalance(), account.getVersion() + 1,
                account.getAccountNo(), account.getVersion()});
        if(updateCount == 0){
            throw new OptimisticLockingFailureException("Did not find row to update");
        }
    }
}
