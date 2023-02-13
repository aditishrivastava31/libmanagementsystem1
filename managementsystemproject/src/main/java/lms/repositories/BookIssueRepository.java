package lms.repositories;

import java.util.List;

import lms.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import lms.entities.BookIssueDetails;

public interface BookIssueRepository extends JpaRepository<BookIssueDetails,Long>{
	
	List<BookIssueDetails> findByUserDetail(UserDetails userDetail);

}
