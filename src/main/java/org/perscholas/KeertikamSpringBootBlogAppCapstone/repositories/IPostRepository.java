package org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<UserPost, Long> {
    UserPost findByPostId(Long postId);
}
