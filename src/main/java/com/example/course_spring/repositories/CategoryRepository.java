package com.example.course_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course_spring.entities.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Long> {
}
