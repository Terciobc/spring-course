package com.example.course_spring.resources;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.course_spring.entities.Categories;
import com.example.course_spring.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    // Get.
    @GetMapping
    public ResponseEntity<List<Categories>> findAll() {
        List<Categories> category = categoryService.findAll();

        return ResponseEntity.ok().body(category);
    }

    // Get by id.
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categories> findById(@PathVariable Long id) {
        Categories category = categoryService.findById(id);

        return ResponseEntity.ok().body(category);
    }

    // Post.
    // @PostMapping
    // public ResponseEntity<Categories> create(@RequestBody Categories category) {
    // category = categoryService.create(category);

    // return ResponseEntity.created(null).body(category);
    // }

    // // Deletar um usuário por id.
    // @DeleteMapping(value = "/{id}")
    // public ResponseEntity<category> delete(@PathVariable Long id) {
    // categoryService.delete(id);

    // return ResponseEntity.noContent().build();
    // }

    // @PutMapping(value = "/{id}")
    // public ResponseEntity<category> update(@PathVariable Long id, category
    // category) {
    // category updatcategory = categoryService.update(category, id);

    // return ResponseEntity.ok().body(updatcategory);
    // }

}
