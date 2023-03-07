package com.example.sanketh.service;

import java.util.List;
import java.util.ArrayList;

import com.example.sanketh.model.Student;
import com.example.sanketh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Inject the UserRepository dependency using @Autowired
    @Autowired
    private UserRepository userRepository;

    // Method to get all users
    public List<Student> getAllUsers() {
        List<Student> userRecords = new ArrayList<>();
        userRepository.findAll().forEach(userRecords::add);
        return userRecords;
    }

    // Method to add a new user
    public void addUser(Student userRecord) {
        userRepository.save(userRecord);
    }

    // Method to delete a user by user ID
    public void deleteUser(int userId) {
        userRepository.deleteById(String.valueOf(userId));
    }

    // Method to update an existing user
    public void updateUser(Student userRecord) {
        userRepository.save(userRecord);
    }
}
