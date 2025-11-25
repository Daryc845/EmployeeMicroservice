package com.employee.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.employee.application.dto.requests.CreateEmployeeRequest;
import com.employee.employee.application.dto.requests.UpdateEmployeeRequest;
import com.employee.employee.application.dto.responses.EmployeeListResponse;
import com.employee.employee.application.dto.responses.GenericResponse;
import com.employee.employee.application.dto.useCases.CreateEmployeeUseCase;
import com.employee.employee.application.dto.useCases.DeactivateEmployeeUseCase;
import com.employee.employee.application.dto.useCases.FindAllEmployeesUseCase;
import com.employee.employee.application.dto.useCases.UpdateEmployeeUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final UpdateEmployeeUseCase updateEmployeeUseCase;
    private final FindAllEmployeesUseCase findAllEmployeesUseCase;
    private final DeactivateEmployeeUseCase deactivateEmployeeUseCase;

    @Autowired
    public EmployeeController(
            CreateEmployeeUseCase createEmployeeUseCase,
            UpdateEmployeeUseCase updateEmployeeUseCase,
            FindAllEmployeesUseCase findAllEmployeesUseCase,
            DeactivateEmployeeUseCase deactivateEmployeeUseCase
    ) {
        this.createEmployeeUseCase = createEmployeeUseCase;
        this.updateEmployeeUseCase = updateEmployeeUseCase;
        this.findAllEmployeesUseCase = findAllEmployeesUseCase;
        this.deactivateEmployeeUseCase = deactivateEmployeeUseCase;
    }

    // =========================================================
    // CREATE EMPLOYEE
    // =========================================================
    @Operation(
        summary = "Registrar un nuevo empleado",
        description = "Crea un empleado nuevo con la información enviada.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Empleado creado correctamente",
                content = @Content(schema = @Schema(implementation = GenericResponse.class))
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Datos inválidos o incompletos",
                content = @Content(schema = @Schema(implementation = GenericResponse.class))
            )
        }
    )
    @PostMapping("/createemployee")
    public GenericResponse createEmployee(
            @RequestBody
            @Parameter(description = "Datos para crear el empleado")
            CreateEmployeeRequest request
    ) {
        return createEmployeeUseCase.execute(request);
    }

    // =========================================================
    // UPDATE EMPLOYEE
    // =========================================================
    @Operation(
        summary = "Actualizar empleado",
        description = "Actualiza la información de un empleado existente.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Empleado actualizado correctamente",
                content = @Content(schema = @Schema(implementation = GenericResponse.class))
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Empleado no encontrado",
                content = @Content(schema = @Schema(implementation = GenericResponse.class))
            )
        }
    )
    @PutMapping("/updateemployee")
    public GenericResponse updateEmployee(
            @RequestBody
            @Parameter(description = "Datos actualizados del empleado")
            UpdateEmployeeRequest request
    ) {
        return updateEmployeeUseCase.execute(request);
    }

    // =========================================================
    // FIND ALL EMPLOYEES
    // =========================================================
    @Operation(
        summary = "Listar todos los empleados",
        description = "Devuelve una lista con todos los empleados registrados.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Lista obtenida correctamente",
                content = @Content(schema = @Schema(implementation = EmployeeListResponse.class))
            )
        }
    )
    @GetMapping("/findallemployees")
    public EmployeeListResponse findAllEmployees() {
        return findAllEmployeesUseCase.execute();
    }

    // =========================================================
    // DISABLE EMPLOYEE
    // =========================================================
    @Operation(
        summary = "Desactivar un empleado",
        description = "Cambia el estado del empleado a INACTIVO según su documento.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Empleado desactivado correctamente",
                content = @Content(schema = @Schema(implementation = GenericResponse.class))
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Empleado no encontrado",
                content = @Content(schema = @Schema(implementation = GenericResponse.class))
            )
        }
    )
    @PutMapping("/disableemployee/{document}")
    public GenericResponse disableEmployee(
            @Parameter(description = "Documento del empleado a desactivar", example = "1029384756")
            @PathVariable String document
    ) {
        return deactivateEmployeeUseCase.execute(document);
    }
}
