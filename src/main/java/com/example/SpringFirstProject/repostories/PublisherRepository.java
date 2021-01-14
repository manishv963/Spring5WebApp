package com.example.SpringFirstProject.repostories;

import com.example.SpringFirstProject.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository  extends CrudRepository<Publisher,Long> {

}
