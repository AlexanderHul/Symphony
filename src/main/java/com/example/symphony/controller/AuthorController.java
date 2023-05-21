package com.example.symphony.controller;

import com.example.symphony.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Optional;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/author/{authorId}")
    public String getAuthor(Model model, @PathVariable Integer authorId){
        model.addAttribute("author", authorService.getAuthorById(authorId));
        return "author";
    }


    @PostMapping("/author/create")
    public String createAuthor(@RequestParam String name, @RequestParam Date dateOfBirth, @RequestParam String description){
        authorService.createAuthor(name, dateOfBirth, null, description);
        return "redirect:/author";
    }

    @PostMapping("/author/delete/{authorId}")
    public String deleteAuthorById(@PathVariable Integer authorId){
        authorService.deleteAuthorById(authorId);
        return "redirect:/author";
    }

    @PostMapping("/author/{authorId}")
    public String updateDescription(@RequestParam String description, @PathVariable Integer authorId){
        authorService.updateAuthorDescription(authorId, description);
        return "redirect:/author/"+authorId;
    }

}
