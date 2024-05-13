package com.example.demo;


import jakarta.transaction.Transactional;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User updateUserDetails(UUID userId, User userDetails) {
        User existingUser = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        // Update user details
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setLoggedIn(userDetails.isLoggedIn());
        existingUser.setTimeZone(userDetails.getTimeZone());
        // Save the updated user
        return userRepository.save(existingUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public Page findAllUsers(PageRequest of) {
        return null;
    }






}
