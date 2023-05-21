package com.example.symphony.repository;

import com.example.symphony.entity.Studio;
import org.springframework.stereotype.Repository;

@Repository
public class StudioRepository extends BasicRepositoryImpl<Studio, Integer> {

    StudioRepository() {
        super(Studio.class);
    }
}
