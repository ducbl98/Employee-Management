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

    public Role createRole(Role role) {
        String roleName = role.getRoleName().toUpperCase();
        if (roleName.startsWith("ROLE_")) {
            role.setRoleName(roleName);
        } else {
            role.setRoleName("ROLE_" + roleName);
        }
        return roleRepository.save(role);
    }

    public Role findRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public void deleteRole(Long id) {
        Role existingRole = findRoleById(id);
        log.info("deleteRole() : {}", existingRole.getId());

        roleRepository.deleteById(id);
    }
}
