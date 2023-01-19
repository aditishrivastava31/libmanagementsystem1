package com.library.managementsystemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.library.managementsystemproject.entities.BookIssueDetails;

@EnableJpaRepositories
public interface BookIssueRepository extends JpaRepository<BookIssueDetails, Long>{

}
