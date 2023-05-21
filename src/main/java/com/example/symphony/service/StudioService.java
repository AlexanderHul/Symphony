package com.example.symphony.service;

import com.example.symphony.entity.Studio;
import com.example.symphony.entity.StudioLink;
import com.example.symphony.repository.BasicRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {
    private final BasicRepositoryImpl<Studio, Integer> studioRepository;
    private final BasicRepositoryImpl<StudioLink, Integer> studioLinkRepository;

    @Autowired
    public StudioService(BasicRepositoryImpl<Studio, Integer> studioRepository, BasicRepositoryImpl<StudioLink, Integer> studioLinkRepository) {
        this.studioRepository = studioRepository;
        this.studioLinkRepository = studioLinkRepository;
    }

    public List<Studio> getAllStudios(){
        return studioRepository.findAll();
    }

    public List<StudioLink> getAllStudiosLinks(){
        return studioLinkRepository.findAll();
    }

    public Studio getStudioById(int id){
        return studioRepository.findById(id);
    }
    public StudioLink getStudioLinkById(int id){
        return studioLinkRepository.findById(id);
    }
    public boolean deleteStudioById(int id){
        try {
            studioRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean deleteStudioLinkById(int id){
        try {
            studioLinkRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public void updateStudioDescription(int id, String description){
        Studio studio = studioRepository.findById(id);
        studio.setDescription(description);
        studioRepository.save(studio);
    }
    public void updateStudioLink(int id, String link){
        StudioLink studioLink = studioLinkRepository.findById(id);
        studioLink.setLink(link);
        studioLinkRepository.save(studioLink);
    }
    public void createStudio(String name, String description){
        Studio studio = new Studio();
        studio.setName(name);
        studio.setDescription(description);
        studioRepository.save(studio);
    }
    public void createStudioLink(int studioId, String link){
        StudioLink studioLink = new StudioLink();
        studioLink.setStudio(studioRepository.findById(studioId));
        studioLink.setLink(link);
        studioLinkRepository.save(studioLink);
        studioRepository.refresh(studioRepository.findById(studioId));
    }
}
