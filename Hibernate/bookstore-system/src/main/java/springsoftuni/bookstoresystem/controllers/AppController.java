package springsoftuni.bookstoresystem.controllers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springsoftuni.bookstoresystem.services.AuthorService;
import springsoftuni.bookstoresystem.services.BookService;
import springsoftuni.bookstoresystem.services.CategoryService;

@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seed data
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();
    }
}
