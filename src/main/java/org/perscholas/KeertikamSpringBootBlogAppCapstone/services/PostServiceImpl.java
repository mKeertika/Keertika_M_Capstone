package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Primary
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostRepository postRepository;
    private UserPost userPost;


//    inserted constructor
    public PostServiceImpl(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }


//    method overriding

    @Override
    public void savePost(UserPost userPost) {

        if (userPost.getPostId()==null){
            userPost.setPublicationDate(LocalDate.now());
        }
        postRepository.save(userPost);

    }

    @Override
    public void deletePostById(Long postId) {

        postRepository.deleteById(postId);

    }

    @Override
    public List<UserPost> getAllPost() {

        List<UserPost> allUserPosts = postRepository.findAll();
        return allUserPosts;
    }

    @Override
    public UserPost getPostById(Long postId) {
        Optional<UserPost> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            UserPost userPost1 = optionalPost.get();
            return userPost1;
        }
         throw new PostNotFoundException();
    }
}