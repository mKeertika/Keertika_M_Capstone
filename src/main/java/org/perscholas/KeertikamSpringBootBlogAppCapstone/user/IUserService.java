package org.perscholas.KeertikamSpringBootBlogAppCapstone.user;

import java.util.List;

public interface IUserService {

    List<User> getAllUser();

    void saveUser(User user);

    User getUserById(Long userId);

    User getUserByName(String userName);

    void deleteUserById(Long userId);


}
