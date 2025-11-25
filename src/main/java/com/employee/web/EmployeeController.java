package com.employee.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.application.dto.requests.CreateEmployeeRequest;
import com.employee.employee.application.dto.requests.UpdateEmployeeRequest;
import com.employee.employee.application.dto.responses.EmployeeListResponse;
import com.employee.employee.application.dto.responses.GenericResponse;
import com.employee.employee.application.dto.useCases.CreateEmployeeUseCase;
import com.employee.employee.application.dto.useCases.DeactivateEmployeeUseCase;
import com.employee.employee.application.dto.useCases.FindAllEmployeesUseCase;
import com.employee.employee.application.dto.useCases.UpdateEmployeeUseCase;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final UpdateEmployeeUseCase updateEmployeeUseCase;
    private final FindAllEmployeesUseCase findAllEmployeesUseCase;
    private final DeactivateEmployeeUseCase deactivateEmployeeUseCase;
    
    @Autowired
    public EmployeeController(CreateEmployeeUseCase createEmployeeUseCase, UpdateEmployeeUseCase updateEmployeeUseCase,
            FindAllEmployeesUseCase findAllEmployeesUseCase, DeactivateEmployeeUseCase deactivateEmployeeUseCase) {
        this.createEmployeeUseCase = createEmployeeUseCase;
        this.updateEmployeeUseCase = updateEmployeeUseCase;
        this.findAllEmployeesUseCase = findAllEmployeesUseCase;
        this.deactivateEmployeeUseCase = deactivateEmployeeUseCase;
    }

    @PostMapping("/createemployee")
    public GenericResponse createEmployee(@RequestBody CreateEmployeeRequest request){
        return createEmployeeUseCase.execute(request);
    }

    @PutMapping("/updateemployee")
    public GenericResponse updateEmployee(@RequestBody UpdateEmployeeRequest request){
        return updateEmployeeUseCase.execute(request);
    }

    @GetMapping("/findallemployees")
    public EmployeeListResponse findAllEmployees(){
        return findAllEmployeesUseCase.execute();
    }

    @PutMapping("/disableemployee/{document}")
    public GenericResponse disableEmployee(@PathVariable String document){
        return deactivateEmployeeUseCase.execute(document);
    }

}
