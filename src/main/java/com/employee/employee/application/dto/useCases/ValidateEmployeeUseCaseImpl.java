package com.employee.employee.application.dto.useCases;

import org.springframework.stereotype.Service;
import com.employee.employee.domain.ports.in.ValidateEmployeeUseCase;
import com.employee.employee.domain.Employee;
import com.employee.employee.domain.EmployeeRepository;
import java.util.Optional;

@Service
public class ValidateEmployeeUseCaseImpl implements ValidateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    public ValidateEmployeeUseCaseImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean validateEmployee(String employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.isPresent() && employee.get().getStatus().getValue();
    }
}