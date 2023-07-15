package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Person;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IPostRepository;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService {


    private final IPersonRepository personRepository;
    private IPostRepository postRepository;


    @Autowired
    public PersonServiceImpl(IPersonRepository personRepository, IPostRepository postRepository) {
        this.personRepository = personRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople;
    }

    @Override
    public void savePerson(Person person) {

        String email = person.getPersonName();
//         Check if the person already exists
        if (personRepository.findFirstByPersonName(email)!=null) {

            throw new IllegalArgumentException("Person with this name already exists.");
        }
//        save to person repo in DB
        personRepository.save(person);
    }

    @Override
    public void saveExistingPerson(Person person) {
//        save to person repo in DB
        personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long personId) {
        Optional<Person> optionalPerson= personRepository.findById(personId);
        if(optionalPerson.isPresent()){
            Person person = optionalPerson.get();
            return person;
        }
        throw new PersonNotFoundException();
    }

    @Override
    public Person getPersonByEmail(String email) {
        Person personByEmail = personRepository.findFirstByEmail(email);

        if(personByEmail !=null){
                throw new PersonNotFoundException();
        }
        return personRepository.save(personByEmail);
    }

    @Override
    public Person getPersonByPersonName(String personName) {

        return  personRepository.findFirstByPersonName(personName);
    }

    @Override
    public void deletePersonById(Long personid) {

        personRepository.deleteById(personid);

    }
}
