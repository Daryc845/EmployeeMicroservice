package com.employee.employee.domain;

import java.util.Objects;

import com.employee.shared.domain.ValueObject;

public class Phone extends ValueObject{
    private final String value;

    private Phone(String value){
        this.value = value;
    }

    public static boolean isValid(String value){
        if (value == null) return false;
        return value.matches("^[0-9]+$");
    }

    public static Phone of(String value){
        return new Phone(value);
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(value, phone.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
