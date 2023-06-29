package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.Post;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostRepository postRepository;
    private Post post;


//    inserted constructor


    public PostServiceImpl(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }


//    method overriding

    @Override
    public void savePost(Post post) {

        if (post.getPostId()==null){
            post.setPublicationDate(LocalDate.now());
        }
        postRepository.save(post);

    }

    @Override
    public void deletePostById(long postId) {

        postRepository.deleteById(postId);

    }

    @Override
    public List<Post> getAllPost() {

        List<Post> allPosts = postRepository.findAll();
        return allPosts;
    }

    @Override
    public Post getPostById(long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post1 = optionalPost.get();
            return post1;
        }
         throw new PostNotFoundException();
    }
}