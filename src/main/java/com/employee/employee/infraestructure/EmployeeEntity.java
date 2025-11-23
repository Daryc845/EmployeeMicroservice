package com.employee.employee.infraestructure;

import com.employee.employee.domain.Employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {
    @Id
    @Column(name = "document", nullable = false, length = 50)
    private String document;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 100)
    private String lastname;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "status", nullable = false)
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
