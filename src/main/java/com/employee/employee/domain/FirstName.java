package com.employee.employee.domain;

import java.util.Objects;

import com.employee.shared.domain.ValueObject;

public class FirstName extends ValueObject{
    private final String value;

    private FirstName(String value){
        this.value = value;
    }

    public static boolean isValid(String value){
        if (value == null) return false;
        return value.matches("^[A-Za-z]+$");
    }


    public static FirstName of(String value){
        return new FirstName(value);
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstName firstName = (FirstName) o;
        return Objects.equals(value, firstName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
