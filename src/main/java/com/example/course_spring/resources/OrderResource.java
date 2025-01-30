package com.example.course_spring.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.course_spring.entities.Order;
import com.example.course_spring.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    // Get.
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> order = orderService.findAll();

        return ResponseEntity.ok().body(order);
    }

    // Get by id.
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order order = orderService.findById(id);

        return ResponseEntity.ok().body(order);
    }

    // Post.
    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        order = orderService.create(order);

        return ResponseEntity.created(null).body(order);
    }

    // // Deletar um usuário por id.
    // @DeleteMapping(value = "/{id}")
    // public ResponseEntity<Order> delete(@PathVariable Long id) {
    // OrderService.delete(id);

    // return ResponseEntity.noContent().build();
    // }

    // @PutMapping(value = "/{id}")
    // public ResponseEntity<Order> update(@PathVariable Long id, Order Order) {
    // Order updatOrder = OrderService.update(Order, id);

    // return ResponseEntity.ok().body(updatOrder);
    // }

}
