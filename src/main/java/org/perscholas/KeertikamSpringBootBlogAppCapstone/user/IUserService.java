package org.perscholas.KeertikamSpringBootBlogAppCapstone.user;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.User;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;

import java.util.List;

public interface IUserService {

    List<User> getAllUser();

    void saveUser(User user);

    User getUserById(Long userId);

    User getUserByEmail(String email);

    void deleteUserById(Long userId);

    UserPost getUserPostById(Long userId, Long userPostId);

    void deleteUserPostById(Long userId, Long userPostId);
}
