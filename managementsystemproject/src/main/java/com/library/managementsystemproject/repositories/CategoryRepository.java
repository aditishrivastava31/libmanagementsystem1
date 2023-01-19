package com.library.managementsystemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.library.managementsystemproject.entities.Category;


public interface  CategoryRepository extends JpaRepository<Category, Long> {
	

}
