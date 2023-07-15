package org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Person;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IPersonRepositoryTest {

    @Autowired
    IPersonRepository personRepository;


    @Test
    void findByPersonName() {

//        Actual
        Person person = personRepository.findByPersonName("Jisha");

//        Assertion
        Assertions.assertThat(person.getPersonName()).isEqualTo("Jisha");

    }

    @Test
    void findByEmail() {

//        Actual
        Person person = personRepository.findByEmail("jisha@gmail.com");

//        Assertion
        Assertions.assertThat(person.getEmail()).isEqualTo("jisha@gmail.com");
    }
}