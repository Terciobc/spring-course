package com.example.course_spring.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.course_spring.entities.User;
import com.example.course_spring.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Lista todos os usuários do banco.
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Lista o usuário pelo id fornecido.
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.get();
    }

    // Cria um novo usuário.
    public User create(User user) {
        return userRepository.save(user);
    }

    // Deleta o usuário pelo id fornecido.
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado!");
        }
        userRepository.deleteById(id);
    }

    // Faz o update do usuário pelo id fornecido.
    public User update(User user, Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado!");
        }
        return userRepository.save(user);
    }
}
