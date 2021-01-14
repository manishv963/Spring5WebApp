package com.example.SpringFirstProject.repostories;

import com.example.SpringFirstProject.domain.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books,Long> {

}
