package org.perscholas.KeertikamSpringBootBlogAppCapstone.user;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUser();

    void saveUser(User user);

    User getUserById(Long userId);

    User getUserByEmail(String email);

    void deleteUserById(Long userId);


}
