package com.employee.employee.application.dto.useCases;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.employee.application.dto.requests.CreateEmployeeRequest;
import com.employee.employee.application.dto.responses.GenericResponse;
import com.employee.employee.domain.Document;
import com.employee.employee.domain.Email;
import com.employee.employee.domain.Employee;
import com.employee.employee.domain.EmployeeRepository;
import com.employee.employee.domain.FirstName;
import com.employee.employee.domain.LastName;
import com.employee.employee.domain.Phone;
import com.employee.shared.infrastructure.EventPublisher;

@Service
@Transactional
public class CreateEmployeeUseCase {
    private final EmployeeRepository repository;
    private final EventPublisher eventPublisher;

    public CreateEmployeeUseCase(EmployeeRepository repository, EventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public GenericResponse execute(CreateEmployeeRequest request) {

        GenericResponse initialResponse = validateInfo(request);
        if(!initialResponse.isSuccess()){
            return initialResponse;
        }

        Employee employee = Employee.create(request.getDocument(), request.getFirstName(), request.getLastName(), request.getEmail(), request.getPhone(), true);

        

        repository.create(employee);

        employee.getDomainEvents().forEach(eventPublisher::publish);
        employee.clearDomainEvents();

        return new GenericResponse(true, "Empleado creado correctamente");
    }

    private GenericResponse validateInfo(CreateEmployeeRequest request){
        if (repository.findById(request.getDocument()).isPresent()) {
            return new GenericResponse(false, "El empleado ya se encuentra registrado");
        }else if(!Document.isValid(request.getDocument())){
            return new GenericResponse(false, "El documento debe contener unicamente números");
        }else if(!FirstName.isValid(request.getFirstName()) || !LastName.isValid(request.getLastName())){
            return new GenericResponse(false, "El nombre del empleado no puede contener números");
        }else if(!Email.isValid(request.getEmail())){
            return new GenericResponse(false, "El email debe contener la siguiente estructura email@dominio.secundario");
        }else if(!Phone.isValid(request.getPhone())){
            return new GenericResponse(false, "El telefono debe contener unicamente números");
        }
        return new GenericResponse(true, "Datos validados");
    }
}
