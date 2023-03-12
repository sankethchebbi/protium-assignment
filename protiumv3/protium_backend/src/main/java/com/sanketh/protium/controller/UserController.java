package com.sanketh.protium.controller;

import com.sanketh.protium.exception.UserNotFoundException;
import com.sanketh.protium.model.User;
import com.sanketh.protium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This annotation marks this class as a REST controller and maps incoming HTTP requests to methods in this class.
@RestController
// This annotation enables cross-origin resource sharing (CORS) for the specified domain.
@CrossOrigin("http://localhost:3000")
public class UserController {

    // This annotation autowires (injects) the UserRepository instance into this class.
    @Autowired
    private UserRepository userRepository;

    // This method handles HTTP POST requests to create a new user and returns the created user object.
    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    // This method handles HTTP GET requests to retrieve a list of all users and returns a list of User objects.
    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // This method handles HTTP GET requests to retrieve a user by their ID and returns the User object with the specified ID.
    // If the user is not found, it throws a UserNotFoundException.
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // This method handles HTTP PUT requests to update a user by their ID and returns the updated User object.
    // If the user is not found, it throws a UserNotFoundException.
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    // This method handles HTTP DELETE requests to delete a user by their ID and returns a success message.
    // If the user is not found, it throws a UserNotFoundException.
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
}
