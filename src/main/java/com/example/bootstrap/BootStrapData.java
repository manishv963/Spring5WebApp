package com.example.bootstrap;

import com.example.domain.Author;
import com.example.domain.Books;
import com.example.domain.Publisher;
import com.example.repostories.AuthorRepository;
import com.example.repostories.BookRepository;
import com.example.repostories.PublisherRepository;
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
        Publisher publisher = new Publisher("Classmate Publications","Mumbai");
        Books book = new Books("Java Collections and Memmory Management","21212");
        eric.getBooksSet().add(book);
        book.getAuthorSet().add(eric);
        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);
        System.out.println(bookRepository.count());



}


}
