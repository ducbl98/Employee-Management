package com.shinbae.mvc.employeemanagement.controller;

import com.shinbae.mvc.employeemanagement.entity.User;
import com.shinbae.mvc.employeemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/fetch-all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        log.info("addUser() : {}", user);
        return userService.createUser(user);
    }
}
