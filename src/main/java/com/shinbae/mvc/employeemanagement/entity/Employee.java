package com.shinbae.mvc.employeemanagement.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shinbae.mvc.employeemanagement.enumeration.Department;
import com.shinbae.mvc.employeemanagement.enumeration.Hour;
import com.shinbae.mvc.employeemanagement.enumeration.Position;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.InputStream;
import java.util.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@Builder
@Slf4j
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birth_day")
    private Date birthDay;

    private String address;

    @Column(name = "hired_date")
    private Date hireDate;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Enumerated(EnumType.STRING)
    private Hour hours;

    @Enumerated(EnumType.STRING)
    private Position position;

    private String country;

    @Transient
    private final String COUNTRY_JSON = "/data/countries.json";

    public Employee() {
        this.setRandomCountry();
        this.department = Department.randomDepartment();
        this.hours = Hour.randomHour();
        this.position = Position.randomPosition();
    }

    public void setRandomCountry() {
        try {
            InputStream inputStream = TypeReference.class.getResourceAsStream(COUNTRY_JSON);
            Map<String, String> countries = new ObjectMapper().readValue(inputStream, HashMap.class);
            List<String> keys = List.copyOf(countries.keySet());
            int randomIndex = new Random().nextInt(keys.size());
            this.country = countries.get(keys.get(randomIndex));
            log.info("Country : {}", this.country);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
