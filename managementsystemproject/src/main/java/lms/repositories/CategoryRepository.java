package lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lms.entities.Category;


public interface  CategoryRepository extends JpaRepository<Category, Long> {
	

}
