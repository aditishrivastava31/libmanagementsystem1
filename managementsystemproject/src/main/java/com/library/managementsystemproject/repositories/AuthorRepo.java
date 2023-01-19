package com.library.managementsystemproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.managementsystemproject.entities.Author;


@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

	
	
	
}
