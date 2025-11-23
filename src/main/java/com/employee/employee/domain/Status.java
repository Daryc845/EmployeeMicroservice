package com.employee.employee.domain;

import java.util.Objects;

import com.employee.shared.domain.ValueObject;

public class Status extends ValueObject{
    private final boolean value;

    private Status(boolean value){
        this.value = value;
    }

    public static boolean isValid(String value) {
        if (value == null) return false;
        return value.matches("(?i)^(true|false)$");
    }


    public static Status of(boolean value){
        return new Status(value);
    }

    public boolean getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(value, status.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
