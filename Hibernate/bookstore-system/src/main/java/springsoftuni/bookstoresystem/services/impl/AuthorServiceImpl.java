package springsoftuni.bookstoresystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsoftuni.bookstoresystem.constants.GlobalConstants;
import springsoftuni.bookstoresystem.entities.Author;
import springsoftuni.bookstoresystem.repositories.AuthorRepository;
import springsoftuni.bookstoresystem.services.AuthorService;
import springsoftuni.bookstoresystem.utils.FileUtil;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static springsoftuni.bookstoresystem.constants.GlobalConstants.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;



    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if(authorRepository.count() != 0) {
            return;
        }
        String[] fileContent = fileUtil
                .readFileContent(AUTHOR_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    String[] params = r.split("\\s+");
                    Author author = new Author(params[0], params[1]);

                    this.authorRepository.saveAndFlush(author);
                } );
    }

    @Override
    public int getAllAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository
                .getOne(id);
    }
}
