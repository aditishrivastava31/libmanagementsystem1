package lms.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.entities.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	
	
	
}
