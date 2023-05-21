package com.example.symphony.controller;

import com.example.symphony.entity.Theatre;
import com.example.symphony.service.PerformanceService;
import com.example.symphony.service.StudioService;
import com.example.symphony.service.TheatrePerformanceService;
import com.example.symphony.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class TheatrePerformanceController {
    private final TheatrePerformanceService theatrePerformanceService;
    private final StudioService studioService;
    private final TheatreService theatreService;
    private final PerformanceService performanceService;

    @Autowired
    public TheatrePerformanceController(TheatrePerformanceService theatrePerformanceService, StudioService studioService, TheatreService theatreService, PerformanceService performanceService) {
        this.theatrePerformanceService = theatrePerformanceService;
        this.studioService = studioService;
        this.theatreService = theatreService;
        this.performanceService = performanceService;
    }

    @GetMapping("/available")
    public String getAvailable(Model model){
        model.addAttribute("filterMessage", "Available Performances");
        model.addAttribute("updatable", false);
        model.addAttribute("theatrePerformances", theatrePerformanceService.getAvailablePerformances());
        return "shows";
    }

    @GetMapping("/show")
    public String getShows(Model model){
        model.addAttribute("theatres", theatreService.getAllTheatres());
        model.addAttribute("studios", studioService.getAllStudios());
        model.addAttribute("performs", performanceService.getAllPerformances());
        model.addAttribute("theatrePerformances", theatrePerformanceService.getAllTheatrePerformance());
        model.addAttribute("filterMessage", "Performance History");
        model.addAttribute("updatable", true);
        return "shows";
    }

    @GetMapping("/theatre/{theatreId}/show")
    public String getShowsByTheatre(@PathVariable Integer theatreId, Model model){
        Theatre theatre = theatreService.getTheatreById(theatreId);
        model.addAttribute("theatrePerformances", theatrePerformanceService.getPerformanceByTheatre(theatreId));
        model.addAttribute("updatable", false);
        model.addAttribute("filterMessage", "History of performances in "+theatre.getName());
        return "shows";
    }

    @GetMapping("/show/{showId}")
    public String getShow(Model model, @PathVariable Integer showId){
        model.addAttribute("theatrePerformance", theatrePerformanceService.getTheatrePerformanceById(showId));
        return "show";
    }


    @PostMapping("/show/create")
    public String createShow(@RequestParam Integer theatreId, @RequestParam Integer studioId, @RequestParam Integer performanceId, @RequestParam Date performDate, @RequestParam Float price){
        theatrePerformanceService.createTheatrePerformance(theatreId, studioId, performanceId, performDate, price);
        return "redirect:/show";
    }

    @PostMapping("/show/delete/{showId}")
    public String deleteShowById(@PathVariable Integer showId){
        theatrePerformanceService.deleteTheatrePerformanceById(showId);
        return "redirect:/show";
    }

    @PostMapping("/show/{showId}")
    public String updatePerformDate(@RequestParam Date performDate, @PathVariable Integer showId){
        theatrePerformanceService.updatePerformDate(showId, performDate);
        return "redirect:/show/"+showId;
    }
}
