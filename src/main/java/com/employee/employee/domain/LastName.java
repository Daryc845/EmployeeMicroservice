package com.employee.employee.domain;

import java.util.Objects;

import com.employee.shared.domain.ValueObject;

public class LastName extends ValueObject{
    private final String value;

    private LastName(String value){
        this.value = value;
    }

    public static boolean isValid(String value){
        if (value == null) return false;
        return value.matches("^[A-Za-z]+$");
    }

    public static LastName of(String value){
        return new LastName(value);
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastName lastName = (LastName) o;
        return Objects.equals(value, lastName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
