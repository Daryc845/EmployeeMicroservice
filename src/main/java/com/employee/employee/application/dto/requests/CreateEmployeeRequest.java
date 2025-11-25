package com.employee.employee.application.dto.requests;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos necesarios para crear un nuevo empleado")
public class CreateEmployeeRequest {

    @Schema(description = "Número de documento del empleado", example = "1029384756")
    private String document;

    @Schema(description = "Primer nombre del empleado", example = "Juan")
    private String firstName;

    @Schema(description = "Apellido del empleado", example = "Pérez")
    private String lastName;

    @Schema(description = "Correo electrónico del empleado", example = "juan.perez@uptc.edu.co")
    private String email;

    @Schema(description = "Número telefónico del empleado", example = "+57 3201234567")
    private String phone;

    @Schema(description = "Estado del empleado", example = "ACTIVE")
    private String status;

    public String getDocument() { return document; }
    public void setDocument(String document) { this.document = document; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
