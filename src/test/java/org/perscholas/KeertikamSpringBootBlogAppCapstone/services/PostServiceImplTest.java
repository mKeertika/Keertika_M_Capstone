package org.perscholas.KeertikamSpringBootBlogAppCapstone.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

class PostServiceImplTest {

    @Autowired
    PostServiceImpl postService;
    @Autowired
    IPostRepository postRepository;

    @DisplayName("Parameterized test")
    @ParameterizedTest
    @ValueSource(longs = {7L, 8L, 9L})
    void testGetPostById(Long postId) {

        postService = new PostServiceImpl(this.postRepository);

        // Arrange
        UserPost expectedPost = new UserPost("Title 1", "Content 1", LocalDate.now(),
                "Keertika");
        UserPost expectedPost1 = new UserPost("Title 2", "Content 2", LocalDate.now(),
                "Keertika");
        UserPost expectedPost2 = new UserPost("Title 3", "Content 3", LocalDate.now(),
                "Keertika");
        postService.savePost(expectedPost);
        postService.savePost(expectedPost1);
        postService.savePost(expectedPost2);

        // Act
        UserPost retrievedPost = postService.getPostById(postId);

        // Assert
        Assertions.assertEquals(expectedPost.getPostId(), retrievedPost.getPostId());
        Assertions.assertEquals(expectedPost1.getPostId(), retrievedPost.getPostId());
        Assertions.assertEquals(expectedPost2.getPostId(), retrievedPost.getPostId());
    }

}