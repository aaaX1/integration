package com.batch.Listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

/**
 * Created by jiangchengyi on 17/9/20.
 * skip监听
 */
@Component
public class StepListener implements StepExecutionListener {

    public static int count = 0;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println(stepExecution.getExitStatus());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {

        System.out.println("i am in step listener ");

        System.out.println(stepExecution.getExitStatus());
        String stepName = stepExecution.getStepName();
        System.out.println("stepName is "+stepName);
        if (stepName.equals("step1"))
            return ExitStatus.FAILED;
        else {
            return null;
        }


    }


}
