package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Person;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonServiceImplTest {

    @Autowired
     IPersonRepository personRepository;

//    I commented below code because Sarah is already in DB now after running this code for first time,
//    in case database has no "sarah" entry then enable below code

//    @BeforeEach
//    void setup() {
//        Person sarah = new Person("Sarah", "Sarah@gmail.com", "sarah");
//        personRepository.save(sarah);
//    }

    @Test
     void test_getPersonByPersonName_should_compare_both_object_findByPersonName() {

//        Actual
        Person person = personRepository.findByPersonName("Sarah");

//        Assertion

        if (person != null) {
            Assertions.assertThat(person.getPersonName()).isEqualTo("Sarah");
        } else {
            Assertions.fail("Person not found");
        }
    }
}