package com.library.managementsystemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.managementsystemproject.entities.BookIssueDetails;

public interface BookIssueRepository extends JpaRepository<BookIssueDetails,Long>{

}
