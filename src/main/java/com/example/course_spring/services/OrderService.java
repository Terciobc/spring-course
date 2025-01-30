package com.example.course_spring.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.course_spring.entities.Order;
import com.example.course_spring.entities.User;
import com.example.course_spring.repositories.OrderRepository;
import com.example.course_spring.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compra não encontrada" + id));

    }

    public Order create(Order order) {
        User client = userRepository.findById(order.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado! "));

        order.setClient(client);

        return orderRepository.save(order);
    }
}
