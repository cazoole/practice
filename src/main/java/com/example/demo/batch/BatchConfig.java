//package com.example.demo.batch;
//
//import com.example.demo.batch.model.Person;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.FlatFileItemWriter;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.ClassPathResource;
//
////@Configuration
////@EnableBatchProcessing
//public class BatchConfig {
//
////    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
////    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    /**
//     * tag::readerWriterProcessor
//     * @return
//     */
//    @Bean
//    public FlatFileItemReader<Person> reader() {
//        return new FlatFileItemReaderBuilder<Person>()
//                .name("personItemReader")
//                .resource(new ClassPathResource("sample-data.csv"))
//                .delimited()
//                .names(new String[]{"name", "hobby","age"})
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>(){{setTargetType(Person.class);}})
//                .build();
//    }
//
//    @Bean
//    public PersonItemProcessor processor() {
//        return new PersonItemProcessor();
//    }
//
//    @Bean
//    public FlatFileItemWriter<Person> writer() {
//        return new FlatFileItemWriterBuilder<Person>()
//                .name("writerToFile")
//                .encoding("UTF-8")
//                .lineSeparator(",")
//                .lineAggregator(item -> item.getName().concat(",").concat(item.getHobby()).concat(",").concat(String.valueOf(item.getAge())))
//                .resource(new ClassPathResource("save-data.csv"))
//                .append(true)
//                .build();
//    }
//
//    @Bean("importUserJob")
//    public Job importUserJob(JobCompletionNoticeListener listener, Step step1) {
//        return jobBuilderFactory.get("importUserJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step1)
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step1(FlatFileItemWriter<Person> writer) {
//        return stepBuilderFactory.get("step1")
//                .<Person, Person> chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer)
//                .build();
//    }
//
//}
