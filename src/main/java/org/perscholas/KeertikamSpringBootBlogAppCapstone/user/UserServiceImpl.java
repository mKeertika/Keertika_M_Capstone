package org.perscholas.KeertikamSpringBootBlogAppCapstone.user;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.User;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IPostRepository;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IUserRepository;
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
    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserServiceImpl(IUserRepository userRepository, IPostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<User> getAllUser() {
        List allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
//        save to user repo in DB
//        userRepository.save(user);

        // Check if the user already exists based on unique attributes (e.g., email)
        if (userExists(user.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists.");
        }

    }

    private boolean userExists(String email) {
        // Check if the user exists based on the email
        // userRepository.findByEmail(email) != null;
        return false;
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
    public void deleteUserById(Long userId) {

        userRepository.deleteById(userId);

    }

    @Override
    public UserPost getUserPostById(Long userId, Long userPostId) {
        User user = userRepository.findById(userId)
                .orElseThrow(new Supplier<IllegalArgumentException>() {
                    @Override
                    public IllegalArgumentException get() {
                        return new IllegalArgumentException("User not found");
                    }
                });
        return user.getUserPosts().stream()
                .filter(userPost -> userPost.getPostId().equals(userPostId))
                .findFirst()
                .orElseThrow(() -> {
                    return new IllegalArgumentException("Blog not found");
                });
    }

    @Override
    public void deleteUserPostById(Long userId, Long userPostId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        UserPost userPost =postRepository.findById(userPostId)
                .orElseThrow(() -> new IllegalArgumentException("Blog not found"));

        if (!user.getUserPosts().contains(userPost)) {
            throw new IllegalArgumentException("Blog does not belong to the user");
        }

        user.getUserPosts().remove(userPost);
        userRepository.save(user);
    }
}
