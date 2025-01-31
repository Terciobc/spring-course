package com.example.course_spring.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.course_spring.entities.Categories;
import com.example.course_spring.entities.Product;
import com.example.course_spring.services.CategoryService;
import com.example.course_spring.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    // Get.
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> product = productService.findAll();

        return ResponseEntity.ok().body(product);
    }

    // Get by id.
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);

        return ResponseEntity.ok().body(product);
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
