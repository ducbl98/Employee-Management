package com.shinbae.mvc.employeemanagement.seed;

import com.shinbae.mvc.employeemanagement.entity.Role;
import com.shinbae.mvc.employeemanagement.entity.User;
import com.shinbae.mvc.employeemanagement.repository.RoleRepository;
import com.shinbae.mvc.employeemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@RequiredArgsConstructor
@Slf4j
public class AdminSeeder implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        seedAdminUser();
    }

    public void seedAdminUser() {
        Role adminRole = Role.builder().roleName("ROLE_ADMIN").build();
        adminRole.setUsers(new HashSet<>());
        Role userRole = Role.builder().roleName("ROLE_USER").build();
        userRole.setUsers(new HashSet<>());

        User admin = User.builder().userName("admin1").email("admin1@gmail.com").password("admin1").build();
        admin.setRoles(new HashSet<>());

        admin.getRoles().add(adminRole);
        adminRole.getUsers().add(admin);

        this.roleRepository.save(adminRole);
        this.roleRepository.save(userRole);
    }
}
