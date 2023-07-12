package org.perscholas.KeertikamSpringBootBlogAppCapstone.repositories;

import jdk.jfr.Registered;
import org.perscholas.KeertikamSpringBootBlogAppCapstone.models.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IImageRepository extends JpaRepository<PostImage, Long> {

//    added a custom method
    PostImage findByPostId();
}
