package com.employee.employee.application.dto.responses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Registro individual dentro de la lista de empleados")
public class EmployeeListItemResponse {

    @Schema(description = "Documento del empleado", example = "1029384756")
    private String document;

    @Schema(description = "Nombre del empleado", example = "Andrea")
    private String firstName;

    @Schema(description = "Apellido del empleado", example = "Ramírez")
    private String lastName;

    @Schema(description = "Correo electrónico del empleado", example = "andrea.ramirez@uptc.edu.co")
    private String email;

    @Schema(description = "Número telefónico", example = "+57 3007654321")
    private String phone;

    @Schema(description = "Estado del empleado", example = "INACTIVE")
    private String status;

    public EmployeeListItemResponse(
            String document,
            String firstName,
            String lastName,
            String email,
            String phone,
            String status
    ) {
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public String getDocument() { return document; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getStatus() { return status; }
}
