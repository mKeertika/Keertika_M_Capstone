package org.perscholas.KeertikamSpringBootBlogAppCapstone.postComments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<PostComment, Long> {
}
