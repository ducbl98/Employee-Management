package com.shinbae.mvc.employeemanagement.controller.restapi;

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

    @PatchMapping("/update-user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        log.info("updateUser() : {}", user);
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return "User deleted successfully";
        } catch (Exception e) {
            log.error("deleteUser() : {}", e.getMessage());
            return "Something went wrong";
        }
    }
}
