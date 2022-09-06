package com.shinbae.mvc.employeemanagement.controller.mvc;

import com.shinbae.mvc.employeemanagement.entity.Role;
import com.shinbae.mvc.employeemanagement.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/roles-mvc")
public class RoleMVCController {
    private final RoleService roleService;

    @GetMapping("/list-roles")
    public ModelAndView listRoles() {
        log.info("listRoles()");
        ModelAndView modelAndView = new ModelAndView("roles-mvc/list-roles");
        List<Role> roles = roleService.getAllRole().stream().map(role -> new Role(role.getId(), role.getRoleName().substring(5))).toList();
        Role newRole = new Role();
        modelAndView.addObject("role",newRole);
        modelAndView.addObject("roles",roles);
        return modelAndView;
    }

    @PostMapping("/create-role")
    public String addRole(@ModelAttribute Role role, BindingResult bindingResult) {
        log.info("addRole()");
        if (bindingResult.hasErrors()) {
            return "roles-mvc/list-roles";
        }
        roleService.createRole(role);
        return "redirect:/roles-mvc/list-roles";
    }

    @GetMapping("/delete-role/{id}")
    public String deleteRole(@PathVariable Long id) {
        log.info("deleteRole()");
        roleService.deleteRole(id);
        return "redirect:/roles-mvc/list-roles";
    }
}
