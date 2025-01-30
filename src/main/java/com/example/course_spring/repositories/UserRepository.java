package com.example.course_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.course_spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
