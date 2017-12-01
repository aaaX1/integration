package com.batch.process;

import com.batch.domain.Person;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by jiangchengyi on 17/9/20.
 */
public class PersonProcess implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person person) throws Exception {
            person.setAge(person.getAge()+1);
            System.out.println("haha "+person.toString());
        return person;
    }
}
