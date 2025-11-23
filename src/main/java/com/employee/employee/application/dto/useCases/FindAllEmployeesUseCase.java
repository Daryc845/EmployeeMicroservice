package com.employee.employee.application.dto.useCases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.employee.employee.application.dto.responses.EmployeeListItemResponse;
import com.employee.employee.application.dto.responses.EmployeeListResponse;
import com.employee.employee.domain.Employee;
import com.employee.employee.domain.EmployeeRepository;

@Service
public class FindAllEmployeesUseCase {
    private final EmployeeRepository repository;

    public FindAllEmployeesUseCase(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeListResponse execute() {

        List<Employee> employees = repository.findAll();

        List<EmployeeListItemResponse> data = employees.stream()
                .filter(e -> e.getStatus().getValue())
                .map(e -> new EmployeeListItemResponse(
                        e.getDocument().getValue(),
                        e.getFirstName().getValue(),
                        e.getLastName().getValue(),
                        e.getEmail().getValue(),
                        e.getPhone().getValue()
                ))
                .collect(Collectors.toList());

        return new EmployeeListResponse(true, "Empleados obtenidos correctamente", data);
    }
}
