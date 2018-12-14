//package com.example.demo.batch;
//
//import com.example.demo.batch.model.Person;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.item.ItemProcessor;
//
//@Slf4j
//public class PersonItemProcessor implements ItemProcessor<Person, Person> {
//    @Override
//    public Person process(final Person person) throws Exception {
//        final String name = person.getName().toUpperCase();
//        final String hobby = person.getHobby().toUpperCase();
//        person.setName(name);
//        person.setHobby(hobby);
//        log.info("After processor = " + person);
//        return person;
//    }
//}
