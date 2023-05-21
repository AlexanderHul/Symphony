package com.example.symphony.service;

import com.example.symphony.entity.Theatre;
import com.example.symphony.repository.BasicRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    private final BasicRepositoryImpl<Theatre, Integer> theatreRepository;

    @Autowired
    public TheatreService(BasicRepositoryImpl<Theatre, Integer> theatreRepository){
        this.theatreRepository = theatreRepository;
    }

    public List<Theatre> getAllTheatres(){
        return theatreRepository.findAll();
    }

    public Theatre getTheatreById(int id){
        return theatreRepository.findById(id);
    }

    public boolean deleteTheatreById(int id){
        try {
            theatreRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public Theatre updateTheatre(Theatre theatre){
        if(theatre.getId() == null){
            return null;
        }
        theatreRepository.save(theatre);
        return theatreRepository.findById(theatre.getId());
    }

    public void updateTheatreDescription(int id, String description){
        Theatre theatre = theatreRepository.findById(id);
        theatre.setDescription(description);
        theatreRepository.save(theatre);
    }

    public void createTheatre(String name, String address, String city, String description){
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        theatre.setCity(city);
        theatre.setDescription(description);
        theatreRepository.save(theatre);
    }
}
