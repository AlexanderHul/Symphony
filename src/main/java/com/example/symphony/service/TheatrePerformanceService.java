package com.example.symphony.service;

import com.example.symphony.entity.*;
import com.example.symphony.repository.BasicRepositoryImpl;
import com.example.symphony.repository.TheatrePerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class TheatrePerformanceService {
    private final TheatrePerformanceRepository theatrePerformanceRepository;
    private final BasicRepositoryImpl<Theatre, Integer> theatreIntegerBasicRepository;
    private final BasicRepositoryImpl<Studio, Integer> studioIntegerBasicRepository;
    private final BasicRepositoryImpl<Performance, Integer> performanceIntegerBasicRepository;

    @Autowired
    public TheatrePerformanceService(BasicRepositoryImpl<TheatrePerformance, Integer> theatrePerformanceRepository, BasicRepositoryImpl<Theatre, Integer> theatreIntegerBasicRepository, BasicRepositoryImpl<Studio, Integer> studioIntegerBasicRepository, BasicRepositoryImpl<Performance, Integer> performanceIntegerBasicRepository) {
        this.theatrePerformanceRepository = (TheatrePerformanceRepository) theatrePerformanceRepository;
        this.theatreIntegerBasicRepository = theatreIntegerBasicRepository;
        this.studioIntegerBasicRepository = studioIntegerBasicRepository;
        this.performanceIntegerBasicRepository = performanceIntegerBasicRepository;
    }

    public List<TheatrePerformance> getAllTheatrePerformance(){
        return theatrePerformanceRepository.findAll();
    }
    public List<TheatrePerformance> getAvailablePerformances(){
        return theatrePerformanceRepository.findFromDate(Date.valueOf(LocalDate.now()));
    }
    public List<TheatrePerformance> getPerformanceByTheatre(int theatreId){
        return theatrePerformanceRepository.findByTheatre(theatreIntegerBasicRepository.findById(theatreId));
    }
    public TheatrePerformance getTheatrePerformanceById(int id){
        return theatrePerformanceRepository.findById(id);
    }
    public boolean deleteTheatrePerformanceById(int id){
        try {
            theatrePerformanceRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void updatePerformDate(int id, Date performDate){
        TheatrePerformance theatrePerformance = theatrePerformanceRepository.findById(id);
        theatrePerformance.setPerformDate(performDate);
        theatrePerformanceRepository.save(theatrePerformance);
    }

    public void createTheatrePerformance(int theatreId, int studioId, int performanceId, Date performDate, float price){
        TheatrePerformance theatrePerformance = new TheatrePerformance();
        theatrePerformance.setTheatre(theatreIntegerBasicRepository.findById(theatreId));
        theatrePerformance.setStudio(studioIntegerBasicRepository.findById(studioId));
        theatrePerformance.setPerformance(performanceIntegerBasicRepository.findById(performanceId));
        theatrePerformance.setPerformDate(performDate);
        theatrePerformance.setPrice(price);
        theatrePerformanceRepository.save(theatrePerformance);
    }
}
