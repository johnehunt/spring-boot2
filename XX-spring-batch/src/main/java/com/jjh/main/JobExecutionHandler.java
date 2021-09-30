package com.jjh.main;

import com.jjh.domain.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobExecutionHandler extends JobExecutionListenerSupport {
    private static final Logger LOG = LoggerFactory.getLogger(JobExecutionHandler.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        LOG.info("!!! Starting Job{}", jobExecution.getJobId());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOG.info("!!! Finished Job{} - Verifying results", jobExecution.getJobId());
            String query = "SELECT symbol, amount, price, value FROM trades";
            jdbcTemplate.query(query, (rs, row) -> new Trade(rs.getString(1),
                            rs.getInt(2),
                            rs.getDouble(3),
                            rs.getDouble(4)))
                    .forEach(t -> LOG.info("Found {} in the database.", t));
        }
    }
}