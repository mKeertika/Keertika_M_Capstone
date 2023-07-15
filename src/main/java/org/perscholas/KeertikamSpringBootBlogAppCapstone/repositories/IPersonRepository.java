package org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

     Person findByPersonName(String userName);
     Person findByEmail(String email);
}
