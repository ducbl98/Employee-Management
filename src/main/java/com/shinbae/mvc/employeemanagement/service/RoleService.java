package com.shinbae.mvc.employeemanagement.service;

import com.shinbae.mvc.employeemanagement.entity.Role;
import com.shinbae.mvc.employeemanagement.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
}
