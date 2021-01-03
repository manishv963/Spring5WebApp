package com.example.repostories;

import com.example.domain.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books,Long> {

}
