package com.example.domain;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy="authors")
    private Set<Books> booksSet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Author(Long id,String firstName, String lastName, Set<Books> booksSet) {

        this.id = id;

        this.firstName = firstName;
        this.lastName = lastName;
        this.booksSet = booksSet;
    }

    //jpa requires default constructor
    public Author(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Books> getBooksSet() {
        return booksSet;
    }

    public void setBooksSet(Set<Books> booksSet) {
        this.booksSet = booksSet;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", booksSet=" + booksSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id == author.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
