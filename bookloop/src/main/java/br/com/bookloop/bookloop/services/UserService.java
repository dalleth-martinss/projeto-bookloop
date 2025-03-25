package br.com.bookloop.bookloop.services;

import br.com.bookloop.bookloop.entities.User;
import br.com.bookloop.bookloop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Método para obter todos os usuários
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Método para obter um usuário por ID
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Método para criar ou atualizar um usuário
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Método para atualizar um usuário
    public User updateUser(Integer id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    // Método para deletar um usuário
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // Método para alterar parte de um usuário
    @Transactional
    public User partialUpdateUser(Integer id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getFullName() != null) {
            existingUser.setFullName(user.getFullName());
        }
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getPhoneNumber() != null) {
            existingUser.setPhoneNumber(user.getPhoneNumber());
        }
        // Adicione outras propriedades aqui conforme necessário
        return userRepository.save(existingUser);
    }
}