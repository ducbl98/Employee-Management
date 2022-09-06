package com.shinbae.mvc.employeemanagement.enumeration;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public enum Hour {
    FULL_TIME("Full Time"),
    PART_TIME("Part Time"),
    FREELANCER("Freelancer"),
    ;

    private final String code;

    Hour(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Hour decode(final String code) {
        return Stream.of(Hour.values())
                .filter(targetEnum -> targetEnum.code.equals(code))
                .findFirst()
                .orElse(null);
    }

    private static final List<Hour> HOURS = List.of(values());
    private static final int SIZE = HOURS.size();
    private static final Random RANDOM = new Random();

    public static Hour randomHour()  {
        return HOURS.get(RANDOM.nextInt(SIZE));
    }
}
