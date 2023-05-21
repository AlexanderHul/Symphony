package com.example.symphony.repository;

import com.example.symphony.entity.Theatre;
import com.example.symphony.entity.TheatrePerformance;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class TheatrePerformanceRepository extends BasicRepositoryImpl<TheatrePerformance, Integer> {
    TheatrePerformanceRepository() {
        super(TheatrePerformance.class);
    }

    public List<TheatrePerformance> findFromDate(Date fromDate) {
        return entityManager.createQuery("select show from TheatrePerformance show where show.performDate >= :fromDate", TheatrePerformance.class).setParameter("fromDate", fromDate).getResultList();
    }

    public List<TheatrePerformance> findByTheatre(Theatre theatre){
        return entityManager.createQuery("select show from TheatrePerformance show where show.theatre = :theatre", TheatrePerformance.class).setParameter("theatre", theatre).getResultList();
    }
}
