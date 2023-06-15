package com.pfma.Service;

import com.pfma.model.User;
import com.pfma.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(UUID id, User user) {
        User existingUser = getUser(id);
        if (existingUser != null) {
            BeanUtils.copyProperties(user, existingUser, "id");
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

}
