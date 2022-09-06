package com.shinbae.mvc.employeemanagement.seed;

import com.shinbae.mvc.employeemanagement.entity.Employee;
import com.shinbae.mvc.employeemanagement.service.EmployeeService;
import com.shinbae.mvc.employeemanagement.utils.RandomBirthday;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

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
            employee.setHireDate(randomDate());
            employeeService.createEmployee(employee);
        }
    }

    public static Date between(Date startInclusive, Date endInclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endInclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);
        return new Date(randomMillisSinceEpoch);
    }

    public Date randomDate() {
        Date start = new Date(2018, Calendar.AUGUST, 20);
        Date end = new Date(2022, Calendar.AUGUST, 20);
        return between(start, end);
    }
}
