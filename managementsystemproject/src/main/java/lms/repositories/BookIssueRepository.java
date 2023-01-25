package lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lms.entities.BookIssueDetails;

public interface BookIssueRepository extends JpaRepository<BookIssueDetails,Long>{

}
