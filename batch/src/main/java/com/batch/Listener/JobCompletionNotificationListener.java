package com.batch.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * Created by jiangchengyi on 17/9/20.
 * job监听
 */
@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    private static final String PERSON_SQL = "SELECT personName, personAge,personSex FROM Person";

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);


    @Override
    public void beforeJob(JobExecution jobExecution) {
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        jobExecution.setStatus(BatchStatus.FAILED);

    }
}