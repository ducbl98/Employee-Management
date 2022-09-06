package com.shinbae.mvc.employeemanagement.seed;

import com.shinbae.mvc.employeemanagement.entity.Role;
import com.shinbae.mvc.employeemanagement.entity.User;
import com.shinbae.mvc.employeemanagement.repository.RoleRepository;
import com.shinbae.mvc.employeemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserSeeder implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void run(String... args) throws Exception {
        seedAdminUser();
        seedUser();
    }

    public void seedAdminUser() {
        Role adminRole = Role.builder().roleName("ROLE_ADMIN").build();
        adminRole.setUsers(new HashSet<>());

        User admin = User.builder().userName("admin1").email("admin1@gmail.com").password(bCryptPasswordEncoder.encode("123456")).build();
        admin.setRoles(new HashSet<>());

        admin.getRoles().add(adminRole);
        adminRole.getUsers().add(admin);

        this.roleRepository.save(adminRole);
    }

    public void seedUser() {
        Role userRole = Role.builder().roleName("ROLE_USER").build();
        userRole.setUsers(new HashSet<>());
        for (int i = 0; i < 10; i++) {
            User user = User.builder().userName("user" + i).email("user" + i + "@gmail.com").password(bCryptPasswordEncoder.encode("123456")).build();
            user.setRoles(new HashSet<>());

            user.getRoles().add(userRole);
            userRole.getUsers().add(user);
        }
        this.roleRepository.save(userRole);
    }
}
