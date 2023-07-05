package org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<UserPost, Long> {
}
