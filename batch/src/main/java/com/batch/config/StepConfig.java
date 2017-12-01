package com.batch.config;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by jiangchengyi on 17/9/20.
 */
@Component
public class StepConfig {

    @Autowired
    private StepBuilderFactory step;

    @Autowired
    StepExecutionListener steplistener;

    @Autowired
    TestTasklet testTasklet;

    @Autowired
    TestTaskLet1 testTaskLet1;

    @Bean
    public Step step1() {
        return step.get("step1").listener(steplistener).tasklet(testTasklet).tasklet(testTaskLet1).build();
    }
}
