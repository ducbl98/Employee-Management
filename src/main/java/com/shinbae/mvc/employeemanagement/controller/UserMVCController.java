package com.shinbae.mvc.employeemanagement.controller;

import com.shinbae.mvc.employeemanagement.entity.User;
import com.shinbae.mvc.employeemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/users-mvc")
public class UserMVCController {
    private final UserService userService;

    @GetMapping({"/list-users","/","list"})
    public ModelAndView listUsers() {
        log.info("listUsers()");
        ModelAndView modelAndView = new ModelAndView("users-mvc/list-users");
        List<User> users = userService.getAllUser();
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @GetMapping("/add-user")
    public ModelAndView addUser() {
        log.info("addUser()");
        ModelAndView modelAndView = new ModelAndView("users-mvc/add-user");
        User newUser = new User();
        modelAndView.addObject("user",newUser);
        return modelAndView;
    }

    @PostMapping("/create-user")
    public String createUser(@ModelAttribute User user) {
        log.info("createUser()");
        userService.createUser(user);
        return "redirect:/users-mvc/list-users";
    }

    @GetMapping("/edit-user/{id}")
    public ModelAndView editUser(@PathVariable Long id) {
        log.info("editUser()");
        ModelAndView modelAndView = new ModelAndView("users-mvc/edit-user");
        User userToEdit = userService.findUserById(id);
        modelAndView.addObject("userEdit",userToEdit);
        return modelAndView;
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute User user) {
        log.info("updateUser()");
        userService.updateUser(user, user.getId());
        return "redirect:/users-mvc/list-users";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        log.info("deleteUser()");
        userService.deleteUser(id);
        return "redirect:/users-mvc/list-users";
    }

}
