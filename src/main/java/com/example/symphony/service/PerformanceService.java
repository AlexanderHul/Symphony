package com.example.symphony.service;

import com.example.symphony.entity.Author;
import com.example.symphony.entity.Performance;
import com.example.symphony.repository.BasicRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {
    private final BasicRepositoryImpl<Performance, Integer> performanceRepository;
    private final BasicRepositoryImpl<Author, Integer> authorIntegerBasicRepository;

    @Autowired
    public PerformanceService(BasicRepositoryImpl<Performance, Integer> performanceRepository, BasicRepositoryImpl<Author, Integer> authorIntegerBasicRepository) {
        this.performanceRepository = performanceRepository;
        this.authorIntegerBasicRepository = authorIntegerBasicRepository;
    }

    public List<Performance> getAllPerformances(){
        return performanceRepository.findAll();
    }
    public Performance getPerformanceById(int id){
        return performanceRepository.findById(id);
    }
    public boolean deletePerformanceById(int id){
        try {
            performanceRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void updatePerformanceDescription(int id, String description){
        Performance performance = performanceRepository.findById(id);
        performance.setDescription(description);
        performanceRepository.save(performance);
    }

    public void createPerformance(String name, int duration, int authorId, String description){
        Author author = authorIntegerBasicRepository.findById(authorId);
        Performance performance = new Performance();
        performance.setName(name);
        performance.setDuration(duration);
        performance.setAuthor(author);
        performance.setDescription(description);
        performanceRepository.save(performance);
    }
}
