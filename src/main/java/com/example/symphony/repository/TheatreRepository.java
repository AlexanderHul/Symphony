package com.example.symphony.repository;

import com.example.symphony.entity.Theatre;
import org.springframework.stereotype.Repository;

@Repository
public class TheatreRepository extends BasicRepositoryImpl<Theatre, Integer> {
    TheatreRepository() {
        super(Theatre.class);
    }
}
