package com.shinbae.mvc.employeemanagement.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.stream.Stream;

public enum Department {
    HUMAN_RESOURCES("Human_Resources"),
    MARKETING("Marketing"),
    TECHNICAL_SUPPORT_TEAM("Technical_Support_Team"),
    FINANCE("Finance"),
    SALES("Sales"),
    IT("IT"),
    ADMINISTRATION("Administration"),
    CUSTOMER_SERVICE("Customer_Service"),
    ENGINEERING("Engineering"),
    PRODUCTION("Production"),
    QUALITY_ASSURANCE("Quality_Assurance"),
    RESEARCH_AND_DEVELOPMENT("Research_and_Development"),
    OPERATIONS("Operations");

    private final String code;

    Department(String code) {
        this.code = code;
    }

    @JsonCreator
    public static Department decode(final String code) {
        return Stream.of(Department.values())
                .filter(targetEnum -> targetEnum.code.equals(code))
                .findFirst()
                .orElse(null);
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    private static final List<Department> DEPARTMENTS = List.of(values());
    private static final int SIZE = DEPARTMENTS.size();

    public static Department randomDepartment() {
        return DEPARTMENTS.get((int) (SIZE * Math.random()));
    }
}
