package springsoftuni.bookstoresystem.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;
}
