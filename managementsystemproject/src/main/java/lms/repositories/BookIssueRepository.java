package lms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lms.entities.BookIssueDetails;
import lms.entities.UserDetails;

public interface BookIssueRepository extends JpaRepository<BookIssueDetails,Long>{
	
	List<BookIssueDetails> findByUserDetail(UserDetails userDetail);

}
