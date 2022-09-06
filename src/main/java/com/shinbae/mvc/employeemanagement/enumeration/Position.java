package com.shinbae.mvc.employeemanagement.enumeration;

import java.util.List;
import java.util.stream.Stream;

public enum Position {
    ADMINISTRATOR("Administrator"),
    ACCOUNTANT("Accoutant"),
    CLERK("Clerk"),
    RECEPTIONIST("Receptionist"),
    LABORER("Laborer"),
    SALES_ASSISTANT("Sales_Assistant"),
    SUPERVISOR("Supervisor"),
    UNION_REPRESENTATIVE("Union_Representative"),
    ;

    private final String code;

    Position(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Position decode(final String code) {
        return Stream.of(Position.values())
                .filter(targetEnum -> targetEnum.code.equals(code))
                .findFirst()
                .orElse(null);
    }

    private static final List<Position> POSITIONS = List.of(values());
    private static final int SIZE = POSITIONS.size();

    public static Position randomPosition() {
        return POSITIONS.get((int) (SIZE * Math.random()));
    }
}
