package com.example.symphony.controller;

import com.example.symphony.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TheatreController {
    private final TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping("/theatre")
    public String getTheaters(Model model){
        model.addAttribute("theatres", theatreService.getAllTheatres());
        return "theatres";
    }

    @GetMapping("/theatre/{theatreId}")
    public String getTheatre(@PathVariable Integer theatreId, Model model){
        model.addAttribute("theatre", theatreService.getTheatreById(theatreId));
        return "theatre";
    }

    @PostMapping("/theatre/create")
    public String createTheatre(@RequestParam String name, @RequestParam String address, @RequestParam String city, @RequestParam String description){
        theatreService.createTheatre(name, address, city, description);
        return "redirect:/theatre";
    }

    @PostMapping("/theatre/delete/{theatreId}")
    public String deleteTheatreById(@PathVariable Integer theatreId){
        theatreService.deleteTheatreById(theatreId);
        return "redirect:/theatre";
    }

    @PostMapping("/theatre/{theatreId}")
    public String updateDescription(@RequestParam String description, @PathVariable Integer theatreId){
        theatreService.updateTheatreDescription(theatreId, description);
        return "redirect:/theatre/"+theatreId;
    }
}
