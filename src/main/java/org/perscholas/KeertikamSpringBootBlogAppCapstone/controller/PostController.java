package org.perscholas.KeertikamSpringBootBlogAppCapstone.controller;

import javax.persistence.*;

public class PostController {
    @Entity
    public static class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column
        private String name;
    }
}
