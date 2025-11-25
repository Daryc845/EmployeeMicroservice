package com.employee.employee.application.dto.responses;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta que contiene la lista completa de empleados")
public class EmployeeListResponse {

    @Schema(description = "Indica si la operación fue exitosa", example = "true")
    private boolean success;

    @Schema(description = "Mensaje asociado a la operación", example = "Listado obtenido correctamente")
    private String message;

    @Schema(description = "Lista de empleados")
    private List<EmployeeListItemResponse> data;

    public EmployeeListResponse(boolean success, String message, List<EmployeeListItemResponse> data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public List<EmployeeListItemResponse> getData() { return data; }
}
