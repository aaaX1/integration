package com.batch.repository;

import com.batch.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by jiangchengyi on 17/9/20.
 */
public interface PersonRepository extends JpaRepository<Person,Long> ,JpaSpecificationExecutor<Person> {

}
