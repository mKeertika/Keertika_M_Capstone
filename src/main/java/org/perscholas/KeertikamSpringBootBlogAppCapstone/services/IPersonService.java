package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Person;

import java.util.List;

public interface IPersonService {

    List<Person> getAllPerson();

    void savePerson(Person person);

    void saveExistingPerson(Person person);

    Person getPersonById(Long personId);

    Person getPersonByEmail(String email);

    Person getPersonByPersonName(String personName);

    void deletePersonById(Long personId);
}
