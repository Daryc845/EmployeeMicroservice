package com.employee.employee.infraestructure;

import com.employee.employee.domain.Employee;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "employees")
public class EmployeeEntity {
    @Id 
    private String document;

    @Field("firstname")
    private String firstname;

    @Field("lastname")
    private String lastname;

    @Field("email")
    private String email;

    @Field("phone")
    private String phone;

    @Field("status")
    private Boolean status;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String document, String firstname, String lastname, String email, String phone,
            Boolean status) {
        this.document = document;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public static EmployeeEntity fromDomain(Employee e) {
        return new EmployeeEntity(
            e.getDocument().getValue(),
            e.getFirstName().getValue(),
            e.getLastName().getValue(),
            e.getEmail().getValue(),
            e.getPhone().getValue(),
            e.getStatus().getValue()
        );
    }

    public Employee toDomain() {
        return Employee.create(
            document,
            firstname,
            lastname,
            email,
            phone,
            status
        );
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}