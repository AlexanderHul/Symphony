package com.example.symphony.service;

import com.example.symphony.entity.Author;
import com.example.symphony.repository.BasicRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AuthorService {
    private final BasicRepositoryImpl<Author, Integer> authorRepository;

    @Autowired
    public AuthorService(BasicRepositoryImpl<Author, Integer> authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
    public Author getAuthorById(int id){
        return authorRepository.findById(id);
    }
    public boolean deleteAuthorById(int id){
        try {
            authorRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public void updateAuthorDateOfDeath(int id, Date dateOfDeath){
        Author author = authorRepository.findById(id);
        author.setDateOfDeath(dateOfDeath);
        authorRepository.save(author);
    }

    public void updateAuthorDescription(int id, String description){
        Author author = authorRepository.findById(id);
        author.setDescription(description);
        authorRepository.save(author);
    }

    public void createAuthor(String name, Date dateOfBirth, Date dateOfDeath, String description){
        Author author = new Author();
        author.setName(name);
        author.setDateOfBirth(dateOfBirth);
        author.setDateOfDeath(dateOfDeath);
        author.setDescription(description);
        authorRepository.save(author);
    }
}
