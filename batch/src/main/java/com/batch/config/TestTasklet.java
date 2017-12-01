package com.batch.config;

import com.batch.domain.Person;
import com.batch.repository.PersonRepository;
import com.batch.service.PersonService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jiangchengyi on 17/9/20.
 */
@Component
public class TestTasklet implements Tasklet {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        List<Person> list =  personRepository.findAll();
        personService.findAll();
        contribution.getExitStatus();
        System.out.println("Im tasklet +++++++++++"+chunkContext);
        return RepeatStatus.CONTINUABLE;
    }
}
