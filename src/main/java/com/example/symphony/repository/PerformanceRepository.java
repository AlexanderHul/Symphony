package com.example.symphony.repository;

import com.example.symphony.entity.Performance;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceRepository extends BasicRepositoryImpl<Performance, Integer> {
    PerformanceRepository() {
        super(Performance.class);
    }
}
