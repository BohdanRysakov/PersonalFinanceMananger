package com.pfma.Service;

import com.pfma.exceptions.UserNotFoundException;
import com.pfma.model.postgresdb1.Budget;
import com.pfma.model.postgresdb1.User;
import com.pfma.repository.postgresdb1.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        user.setId(UUID.randomUUID());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public Optional<User> getUser(UUID id) {
        return userRepository.findById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public void addUserToBudget(UUID userId, Budget budget) {
        User user = getUser(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.getOperations().addAll(budget.getOperations());
        userRepository.save(user);
    }
}