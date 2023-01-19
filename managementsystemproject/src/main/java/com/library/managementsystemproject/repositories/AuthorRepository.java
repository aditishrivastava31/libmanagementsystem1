package com.library.managementsystemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.managementsystemproject.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
