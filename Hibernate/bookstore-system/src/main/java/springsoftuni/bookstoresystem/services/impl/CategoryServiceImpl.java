package springsoftuni.bookstoresystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsoftuni.bookstoresystem.entities.Category;
import springsoftuni.bookstoresystem.repositories.CategoryRepository;
import springsoftuni.bookstoresystem.services.CategoryService;
import springsoftuni.bookstoresystem.utils.FileUtil;

import java.io.IOException;
import java.util.Arrays;

import static springsoftuni.bookstoresystem.constants.GlobalConstants.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedCategories() throws IOException {
        if(categoryRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil
                .readFileContent(CATEGORIES_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    Category category = new Category(r);

                    this.categoryRepository.saveAndFlush(category);
                });
    }
}
