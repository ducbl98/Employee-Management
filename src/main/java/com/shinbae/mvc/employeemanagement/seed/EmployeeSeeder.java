package com.shinbae.mvc.employeemanagement.seed;

import com.shinbae.mvc.employeemanagement.entity.Employee;
import com.shinbae.mvc.employeemanagement.repository.EmployeeRepository;
import com.shinbae.mvc.employeemanagement.service.EmployeeService;
import com.shinbae.mvc.employeemanagement.utils.RandomBirthday;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmployeeSeeder implements CommandLineRunner {
    private final EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        seedEmployees();
    }

    public void seedEmployees() {
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setEmail("employee" + i + "@gmail.com");
            employee.setName("employee" + i);
            employee.setPhoneNumber("010-1234-567" + i);
            employee.setAddress("address" + i);
            employee.setBirthDay(new RandomBirthday().getDate());
            employee.setHireDate(new Date());
            employeeService.createEmployee(employee);
        }
    }
}
