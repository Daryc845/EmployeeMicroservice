package com.employee.employee.application.dto.requests;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos necesarios para actualizar la información de un empleado existente")
public class UpdateEmployeeRequest {

    @Schema(description = "Número de documento del empleado", example = "1029384756")
    private String document;

    @Schema(description = "Nuevo primer nombre del empleado", example = "Carlos")
    private String firstName;

    @Schema(description = "Nuevo apellido del empleado", example = "Gómez")
    private String lastName;

    @Schema(description = "Nuevo correo electrónico del empleado", example = "carlos.gomez@uptc.edu.co")
    private String email;

    @Schema(description = "Nuevo número telefónico del empleado", example = "+57 3109876543")
    private String phone;

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
}
