package com.employee.employee.domain;

import com.employee.shared.domain.AggregateRoot;

public class Employee extends AggregateRoot<Document>{
    private Document document;
    private FirstName firstName;
    private LastName lastName;
    private Email email;
    private Phone phone;
    private Status status;

    private Employee(Document document, FirstName firstName, LastName lastName, Email email, Phone phone, Status status) {
        super(document);
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public static Employee create(String document, String firstName, String lastName, String email, String phone, boolean status){
        return new Employee(
            Document.of(document), 
            FirstName.of(firstName), 
            LastName.of(lastName), 
            Email.of(email), 
            Phone.of(phone), 
            Status.of(status));
    }

    public void update(String document, String firstName, String lastName, String email, String phone){
        this.document = Document.of(document);
        this.firstName = FirstName.of(firstName);
        this.lastName = LastName.of(lastName);
        this.email = Email.of(email);
        this.phone = Phone.of(phone);
    }

    public void setStatus(boolean value){
        this.status = Status.of(value);
    }

    public Document getDocument() {
        return document;
    }

    public FirstName getFirstName() {
        return firstName;
    }

    public LastName getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public Phone getPhone() {
        return phone;
    }

    public Status getStatus() {
        return status;
    }
    
}
