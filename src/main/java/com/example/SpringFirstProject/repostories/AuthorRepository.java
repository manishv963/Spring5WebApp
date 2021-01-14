package com.example.SpringFirstProject.repostories;

import com.example.SpringFirstProject.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
