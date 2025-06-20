package com.tomaz.finance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomaz.finance.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
