package com.employee.employee.application.dto.responses;

public class EmployeeListItemResponse {
    private String document;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public EmployeeListItemResponse(String document, String firstName, String lastName, String email, String phone) {
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getDocument() { return document; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}
