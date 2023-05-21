package com.example.symphony.repository;

import com.example.symphony.entity.StudioLink;
import org.springframework.stereotype.Repository;

@Repository
public class StudioLinkRepository extends BasicRepositoryImpl<StudioLink, Integer> {
    StudioLinkRepository() {
        super(StudioLink.class);
    }
}
