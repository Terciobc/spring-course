package com.example.course_spring.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.course_spring.entities.User;
import com.example.course_spring.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    // Get.
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();

        return ResponseEntity.ok().body(users);
    }

    // Get by id.
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);

        return ResponseEntity.ok().body(user);
    }

    // Post.
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        user = userService.create(user);

        return ResponseEntity.created(null).body(user);
    }

    // Deletar um usuário por id.
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, User user) {
        User updatUser = userService.update(user, id);

        return ResponseEntity.ok().body(updatUser);
    }

}
