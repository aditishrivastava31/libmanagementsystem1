package lms.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.entities.BookDetails;


@Repository
public interface BookRepository extends JpaRepository<BookDetails,Long> {
	

	
}
