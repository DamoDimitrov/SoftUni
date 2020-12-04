package springsoftuni.bookstoresystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsoftuni.bookstoresystem.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
