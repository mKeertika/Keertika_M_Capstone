package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import net.bytebuddy.implementation.bytecode.Throw;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.User;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IPostRepository;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {


    private final IUserRepository userRepository;
    private IPostRepository postRepository;


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

        String email = user.getUserName();
//         Check if the user already exists
        if (userRepository.findFirstByUserName(email)!=null) {

//            throw new IllegalArgumentException("User with this name already exists.");
        }
//        save to user repo in DB
        userRepository.save(user);
    }

    @Override
    public void saveExistingUser(User user) {
//        save to user repo in DB
        userRepository.save(user);
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
        User userByEmail = userRepository.findFirstByEmail(email);

        if(userByEmail!=null){
                throw new UserNotFoundException();
        }
        return userRepository.save(userByEmail);
    }

    @Override
    public User getUserByUserName(String userName) {

        return  userRepository.findFirstByUserName(userName);
    }

    @Override
    public void deleteUserById(Long userId) {

        userRepository.deleteById(userId);

    }
}
