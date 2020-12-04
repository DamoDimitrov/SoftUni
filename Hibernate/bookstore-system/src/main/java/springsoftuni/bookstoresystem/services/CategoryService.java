package springsoftuni.bookstoresystem.services;

import org.springframework.stereotype.Service;
import springsoftuni.bookstoresystem.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;

    int getAllCategoriesCount();

    Category getCategoryById(Long i);
}
