package com.shinbae.mvc.employeemanagement.controller.restapi;

import com.shinbae.mvc.employeemanagement.entity.Role;
import com.shinbae.mvc.employeemanagement.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@Slf4j
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/fetch-all")
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }

    @PostMapping("/create")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        try {
            roleService.deleteRole(id);
            return "Role deleted successfully";
        } catch (Exception e) {
            log.error("deleteRole() : {}", e.getMessage());
            return "Something went wrong";
        }
    }

}
