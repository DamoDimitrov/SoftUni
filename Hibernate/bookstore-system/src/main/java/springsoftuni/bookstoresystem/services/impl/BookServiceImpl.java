package springsoftuni.bookstoresystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsoftuni.bookstoresystem.constants.GlobalConstants;
import springsoftuni.bookstoresystem.repositories.BookRepository;
import springsoftuni.bookstoresystem.services.BookService;
import springsoftuni.bookstoresystem.utils.FileUtil;

import java.io.IOException;
import java.util.Arrays;

import static springsoftuni.bookstoresystem.constants.GlobalConstants.BOOKS_FILE_PATH;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if(bookRepository.count() != 0) {
            return;
        }

        String[] fileContent = fileUtil
                .readFileContent(BOOKS_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    String[] params = r.split("\\s+");
                    System.out.println();
                });
    }
}
