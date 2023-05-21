package com.example.symphony.repository;

import com.example.symphony.entity.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository extends BasicRepositoryImpl<Author, Integer>{
    AuthorRepository() {
        super(Author.class);
    }
}
