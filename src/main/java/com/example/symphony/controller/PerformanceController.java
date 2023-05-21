package com.example.symphony.controller;

import com.example.symphony.service.AuthorService;
import com.example.symphony.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PerformanceController {
    private final PerformanceService performanceService;
    private final AuthorService authorService;

    @Autowired
    public PerformanceController(PerformanceService performanceService, AuthorService authorService) {
        this.performanceService = performanceService;
        this.authorService = authorService;
    }

    @GetMapping("/perform")
    public String getAllPerformances(Model model){
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("performances", performanceService.getAllPerformances());
        return "performances";
    }

    @GetMapping("/perform/{performId}")
    public String getPerformanceById(Model model, @PathVariable Integer performId){
        model.addAttribute("performance", performanceService.getPerformanceById(performId));
        return "performance";
    }


    @PostMapping("/perform/create")
    public String createPerformance(@RequestParam String name, @RequestParam Integer authorId, @RequestParam Integer duration, @RequestParam String description){
        performanceService.createPerformance(name, duration, authorId, description);
        return "redirect:/perform";
    }

    @PostMapping("/perform/delete/{performId}")
    public String deletePerformanceById(@PathVariable Integer performId){
        performanceService.deletePerformanceById(performId);
        return "redirect:/perform";
    }

    @PostMapping("/perform/{performId}")
    public String updateDescription(@RequestParam String description, @PathVariable Integer performId){
        performanceService.updatePerformanceDescription(performId, description);
        return "redirect:/perform/"+performId;
    }
}
