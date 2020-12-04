package springsoftuni.bookstoresystem.services;


import springsoftuni.bookstoresystem.entities.Author;

import java.io.IOException;

public interface AuthorService {
    void seedAuthors() throws IOException;
    int getAllAuthorsCount();
    Author findAuthorById(Long id);
}
