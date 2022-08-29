package com.shinbae.mvc.employeemanagement.service;

import com.shinbae.mvc.employeemanagement.entity.Role;
import com.shinbae.mvc.employeemanagement.entity.User;
import com.shinbae.mvc.employeemanagement.repository.RoleRepository;
import com.shinbae.mvc.employeemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User createUser(User user) {
        Role role = roleRepository.findById(1L).orElse(null);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user, Long id) {
        User existingUser = findUserById(id);
        if (existingUser == null) {
            throw new RuntimeException("User not found");
        }
        existingUser.setUserName(user.getUserName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        User existingUser = findUserById(id);
        log.info("deleteUser() : {}", existingUser.getId());
        if (existingUser == null) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }


}
