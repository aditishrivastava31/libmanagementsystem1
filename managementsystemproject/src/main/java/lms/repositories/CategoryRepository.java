package lms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lms.entities.Category;


public interface  CategoryRepository extends JpaRepository<Category, Long> {
	
	public List<Category> findByCategoryName(String name);	
	
}
