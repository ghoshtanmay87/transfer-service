package com.transfer.dao.impl;

import com.transfer.dao.TransferDataDao;
import com.transfer.model.TransferData;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * This is TransferDataDao implementation to access TransferData from database
 *
 * @author Tanmay G
 *
 */
@Repository
public class TransferDataDaoImpl extends JdbcDaoSupport implements TransferDataDao {

    public TransferDataDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public void saveTransferData(TransferData transferData) {
        String query = "insert into transfer_data (transfer_id, source_ac, destination_ac, amount, " +
                "transfer_status, transfer_timestamp) values (?, ?, ?, ?, ?, current_timestamp())";
        getJdbcTemplate().update(query, new Object[]{transferData.getTransactionId(), transferData.getSourceAccountNo(),
        transferData.getDestinationAccountNo(), transferData.getAmount(), transferData.getTransactionStatus().name()});
    }
}
