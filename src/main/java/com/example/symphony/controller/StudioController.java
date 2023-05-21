package com.example.symphony.controller;

import com.example.symphony.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudioController {
    private final StudioService studioService;

    @Autowired
    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @GetMapping("/studio")
    public String getAuthors(Model model){
        model.addAttribute("studios", studioService.getAllStudios());
        return "studios";
    }

    @GetMapping("/studio/{studioId}")
    public String getAuthor(Model model, @PathVariable Integer studioId){
        model.addAttribute("studio", studioService.getStudioById(studioId));
        return "studio";
    }


    @PostMapping("/studio/create")
    public String createAuthor(@RequestParam String name, @RequestParam String description){
        studioService.createStudio(name, description);
        return "redirect:/studio";
    }
    @PostMapping("/studio/{studioId}/create")
    public String addLink(@RequestParam String link, @PathVariable Integer studioId){
        studioService.createStudioLink(studioId, link);
        return "redirect:/studio/"+studioId;
    }
    @PostMapping("/studio/delete/{studioId}")
    public String deleteAuthorById(@PathVariable Integer studioId){
        studioService.deleteStudioById(studioId);
        return "redirect:/studio";
    }

    @PostMapping("/studio/{studioId}")
    public String updateDescription(@RequestParam String description, @PathVariable Integer studioId){
        studioService.updateStudioDescription(studioId, description);
        return "redirect:/studio/"+studioId;
    }
}
