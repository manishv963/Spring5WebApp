package com.example.SpringFirstProject.bootstrap;

import com.example.SpringFirstProject.domain.Author;
import com.example.SpringFirstProject.domain.Books;
import com.example.SpringFirstProject.domain.Publisher;
import com.example.SpringFirstProject.repostories.AuthorRepository;
import com.example.SpringFirstProject.repostories.BookRepository;
import com.example.SpringFirstProject.repostories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData  implements CommandLineRunner{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        System.out.println("loaded from repository package");

        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;

        this.publisherRepository=publisherRepository;

    }
    @Override
    public void run(String... args) throws Exception{
        System.out.println("loaded from repository package");

        Author eric = new Author("Eric","Evans");
        Author manish = new Author("Manish","Vasandnani");

        Publisher publisher1 = new Publisher("Classmate Publication","Pawai  Chowk","Ulhasnagar","Maharashtra",421004L);
        Publisher publisher2 = new Publisher("Sundarama Publication","C Block  ","Ulhasnagar","Maharashtra", 421003L);

        Books book = new Books("Java Collections and Memmory Management","21212");
        Books book1 = new Books("Java Spring Boot","247845");


        authorRepository.save(eric);
        authorRepository.save(manish);

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);
        book.setPublisher(publisher1);
        book1.setPublisher(publisher1);
        bookRepository.save(book);
        bookRepository.save(book1);
        manish.getBooksSet().add(book1);
        eric.getBooksSet().add(book);
        book.getAuthorSet().add(eric);

        publisher1.getBooks().add(book1);
        publisher1.getBooks().add(book);
        System.out.println("Number of Books published by "+publisher1.getName()+" are " +publisher1.getBooks().size());
        System.out.println(publisherRepository.count());



}


}
