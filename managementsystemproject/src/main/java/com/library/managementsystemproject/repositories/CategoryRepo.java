package com.library.managementsystemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.managementsystemproject.entities.Category;


public interface CategoryRepo extends JpaRepository<Category, Long> {
	

}
