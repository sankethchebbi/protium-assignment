package com.example.sanketh.controller;

import com.example.sanketh.model.Student;
import com.example.sanketh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    // Inject the UserService dependency using @Autowired
    @Autowired
    private UserService userService;

    // Endpoint to get all users
    @RequestMapping("/all")
    public List<Student> getAllUser() {
        return userService.getAllUsers();
    }

    // Endpoint to add a new user
    @RequestMapping(value="/add-user", method=RequestMethod.POST)
    public void addUser(@RequestBody Student userRecord) {
        userService.addUser(userRecord);
    }

    // Endpoint to delete a user by user ID
    @RequestMapping(value = "/delete-user/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
    }

    // Endpoint to update an existing user
    @RequestMapping(value="/update-user", method=RequestMethod.PUT)
    public void updateUser(@RequestBody Student userRecord) {
        userService.updateUser(userRecord);
    }
}
