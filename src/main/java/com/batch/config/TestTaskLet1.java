package com.batch.config;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

/**
 * Created by jiangchengyi on 17/9/20.
 */
@Component
public class TestTaskLet1 implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        System.out.println("im tasklet1111_-----------"+(chunkContext.getStepContext().getStepExecution().getReadCount()));
        return RepeatStatus.FINISHED;
    }
}
