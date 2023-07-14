package org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

     User findFirstByUserName(String userName);
     User findFirstByEmail(String email);
}
