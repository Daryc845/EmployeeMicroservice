package com.employee.employee.application.dto.responses;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta estándar para operaciones de éxito o error")
public class GenericResponse {

    @Schema(description = "Indica si la operación fue exitosa", example = "true")
    private boolean success;

    @Schema(description = "Mensaje asociado a la respuesta", example = "Empleado creado correctamente")
    private String message;

    public GenericResponse() {}

    public GenericResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
