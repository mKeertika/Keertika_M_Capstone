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

//    @BeforeEach
//    void setup() {
//        Person sarah = new Person("Sarah");
//        personRepository.save(sarah);
//    }

    @Test
     void getPersonByPersonName() {

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