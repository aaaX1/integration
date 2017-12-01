package com.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by jiangchengyi on 17/9/20.
 */
@Configuration
@EnableBatchProcessing()
public class PersonBatchJob1Config {
    @Autowired
    private JobBuilderFactory job;

//    @Autowired
//    private StepBuilderFactory step;
//
//    @Autowired
//    TestTasklet testTasklet;
//
//    @Autowired
//    TestTaskLet1 testTaskLet1;

    @Autowired
    StepConfig stepConfig;
    //    @Bean
    //    public PlatformTransactionManager transactionManager(DataSource dataSource) {
    //        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
    //        return transactionManager;
    //    }
    @Autowired
    StepExecutionListener steplistener;

//    @Bean
//    public ItemReader<Person> reader() {
//
//        //        FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();
//        //        reader.setResource(new ClassPathResource("person.csv"));
//        //
//        //        reader.setLineMapper(new DefaultLineMapper<Person>(){{
//        //            setLineTokenizer(new DelimitedLineTokenizer(){{
//        //                setNames(new String[]{"name","age","address"});
//        //            }});
//        //            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>(){{
//        //                setTargetType(Person.class);
//        //            }});
//        //        }});
//        //
//        //        return reader;
//        JdbcCursorItemReader<Person> reader = new JdbcCursorItemReader<>();
//        System.out.println("i  in this ");
//
//        reader.setSql("select * from person where id=5");
//        reader.setDataSource(dataSource);
//        reader.setRowMapper((ResultSet resultSet, int rowNum) -> {
//            Person recordSO = new Person();
//            recordSO.setId(resultSet.getLong("id"));
//            recordSO.setName(resultSet.getString("name"));
//            recordSO.setAge(resultSet.getInt("age"));
//            recordSO.setAddress(resultSet.getString("address"));
//            System.out.println("age is" + recordSO.getAge());
//            return recordSO;
//        });
//        return reader;
//    }
//
//    //2.处理数据
//    @Bean
//    public PersonProcess processor() {
//        return new PersonProcess();
//    }
//
//    //3.写数据
//    @Bean
//    public ItemWriter<Person> writer() {
//        System.out.println("i am w1");
//        //        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
//        //        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        //        String sql = "insert into person(name,age,address) values (:name, :age, :address)";
//        //        writer.setSql(sql);
//        //        writer.setDataSource(dataSource);
//        //        return writer;
//
//
//        //        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
//        //                writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
//        //                String sql = "update person set age = :age where name= :name";
//        //                writer.setSql(sql);
//        //                writer.setDataSource(dataSource);
//        //                return writer;
//
//        FlatFileItemWriter<Person> writer = new FlatFileItemWriter<Person>();
//        writer.setResource(new FileSystemResource("/Users/test/write.csv"));
//        DelimitedLineAggregator<Person> delLineAgg = new DelimitedLineAggregator<Person>();
//        delLineAgg.setDelimiter(",");
//        BeanWrapperFieldExtractor<Person> fieldExtractor = new BeanWrapperFieldExtractor<Person>();
//        fieldExtractor.setNames(new String[]{"id", "name", "age", "address"});
//        delLineAgg.setFieldExtractor(fieldExtractor);
//        writer.setLineAggregator(delLineAgg);
//        return writer;
//    }
//
//    @Bean
//    public ItemReader<Person> reader2() {
//
//        FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();
//        reader.setResource(new ClassPathResource("person.csv"));
//
//        reader.setLineMapper(new DefaultLineMapper<Person>() {{
//            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setNames(new String[]{"name", "age", "address"});
//            }});
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
//                setTargetType(Person.class);
//            }});
//        }});
//
//        return reader;
//
//    }
//
//    @Bean
//    public PersonProcess2 processor2() {
//        return new PersonProcess2();
//    }
//
//    @Bean
//    public ItemWriter<Person> writer2() {
//        System.out.println("i am w2");
//        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        String sql = "insert into person(name,age,address) values (:name, :age, :address)";
//        writer.setSql(sql);
//        writer.setDataSource(dataSource);
//        return writer;
//
//
//    }

    @Bean
    public Job importUserJob(JobExecutionListener listener) {
        return job.get("importUserJob")
                //                .incrementer(new RunIdIncrementer())
                .listener(listener)
                //                .start(s1).next(s2)
                //                .build();
                ////                .flow(s1)
                ////                .next(s2)
                ////                .end()
                ////                .build();
                .start(stepConfig.step1()).build();
//                .to(step2())
//                .from(step1()).next(step3())
//                .end()
//                .build();
    }

    /**
     *

     * @return
     * 为了测试step失败使用监听,将状态改为失败
     */
//    @Bean
//    public Step step1() {
//        return step.get("step1").listener(steplistener).tasklet(testTasklet).tasklet(testTaskLet1).build();
////        return step.get("step1").listener(steplistener).<Person, Person>chunk(1)
////                .reader(reader())
////                .processor(processor())
////                .writer(writer())
////                .build();
//    }

//    @Bean
//    public Step step2() {
//        return step.get("step2").<Person, Person>chunk(1)
//                .reader(reader2())
//                .processor(processor2())
//                .writer(writer())
//                .build();
//    }
//
//    @Bean
//    public Step step3() {
//        return step.get("step3").<Person, Person>chunk(1)
//                .reader(reader2())
//                .processor(processor())
//                .writer(writer2())
//                .build();
//    }

}
