package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.User;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;

import java.util.List;

public interface IUserService {

    List<User> getAllUser();

    void saveUser(User user);

    void saveExistingUser(User user);

    User getUserById(Long userId);

    User getUserByEmail(String email);

    User getUserByUserName(String username);

    void deleteUserById(Long userId);
}
