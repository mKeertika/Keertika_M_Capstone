package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.apache.catalina.User;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private final IPostRepository postRepository;

    //    inserted constructor
    public PostServiceImpl(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }


//    method overriding

    @Override
    public void savePost(UserPost userPost) {

        if ((userPost.getPostId())!= null) {
            userPost.setPublicationDate(LocalDate.now());
        }
        postRepository.save(userPost);

    }

    @Override
    public void deletePostById(Long postId) {

        postRepository.deleteById(postId);

    }

    @Override
    public List<UserPost> getAllUserPost() {
        return postRepository.findAll();
    }


    @Override
    public UserPost getPostById(Long userPostId) {
        Optional<UserPost> optionalPost = postRepository.findById(userPostId);
        if (optionalPost.isPresent()) {
            UserPost userPost1 = optionalPost.get();
            return userPost1;
        }
        throw new PostNotFoundException();
    }

    @Override
    public Object getAllPost() {
        return postRepository.findAll();
    }

}
