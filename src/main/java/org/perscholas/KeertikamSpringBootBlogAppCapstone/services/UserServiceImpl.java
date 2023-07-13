package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.User;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IPostRepository;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IUserRepository;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IUserService;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private IPostRepository postRepository;


//    Constructor

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, IPostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUsers = userRepository.findAll();

        return allUsers;
    }

    @Override
    public void saveUser(User user) {

        // Check if the user already exists
//        if (userRepository.findByEmail()) {
//            throw new IllegalArgumentException("User with this email already exists.");
//        }

//        save to user repo in DB
        userRepository.save(user);
    }

    private boolean userExists(String email) {
        // Check if the user exists based on the email
        User userByEmail = userRepository.findByEmail(email);
        return userByEmail!=null;
    }



    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser= userRepository.findById(userId);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return user;
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserByUserName(String userName) {
       return  userRepository.findFirstByUserName(userName);
    }

    @Override
    public void deleteUserById(Long userId) {

        userRepository.deleteById(userId);

    }

    @Override
    public UserPost getUserPostById(Long userId, Long userPostId) {
        return null;
    }

    @Override
    public void deleteUserPostById(Long userId, Long userPostId) {

    }

}
