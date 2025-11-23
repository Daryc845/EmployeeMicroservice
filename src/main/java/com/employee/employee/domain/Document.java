package com.employee.employee.domain;

import java.util.Objects;

import com.employee.shared.domain.ValueObject;

public class Document extends ValueObject {
    private final String value;

    private Document(String value){
        this.value = value;
    }

    public static boolean isValid(String value){
        if (value == null) return false;
        return value.matches("^[0-9]+$");
    }

    public static Document of(String value){
        return new Document(value);
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(value, document.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
