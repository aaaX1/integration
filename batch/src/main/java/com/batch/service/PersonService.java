package com.batch.service;


import com.batch.domain.Person;

import java.util.List;

/**
 * Created by jiangchengyi on 2017/9/29.
 */
public interface PersonService {

    List<Person> findAll();
}
