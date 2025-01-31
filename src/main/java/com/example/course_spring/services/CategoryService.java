package com.example.course_spring.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.course_spring.entities.Categories;
import com.example.course_spring.repositories.CategoryRepository;
import com.example.course_spring.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Categories> findAll() {
        return categoryRepository.findAll();
    }

    public Categories findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compra não encontrada" + id));

    }

    // public Categories create(Categories categories) {
    // if (categories.getClient() == null || categories.getClient().getId() == null)
    // {
    // throw new IllegalArgumentException("Cliente não pode ser nulo");
    // }

    // User client = userRepository.findById(categories.getClient().getId())
    // .orElseThrow(() -> new RuntimeException("Cliente não encontrado! "));

    // categories.setClient(client);

    // return categoryRepository.save(categories);
    // }
}
