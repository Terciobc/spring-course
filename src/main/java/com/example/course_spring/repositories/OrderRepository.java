package com.example.course_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course_spring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
