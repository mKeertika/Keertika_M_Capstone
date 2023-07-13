package org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
     User findByEmail(String email);

}
