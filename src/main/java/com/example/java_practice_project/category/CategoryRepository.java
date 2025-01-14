package com.example.java_practice_project.category;

import com.example.java_practice_project.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
