package springsoftuni.bookstoresystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsoftuni.bookstoresystem.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
