package com.employee.employee.application.dto.useCases;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.employee.application.dto.responses.GenericResponse;
import com.employee.employee.domain.Document;
import com.employee.employee.domain.Employee;
import com.employee.employee.domain.EmployeeRepository;
import com.employee.shared.infrastructure.EventPublisher;

@Service
@Transactional
public class DeactivateEmployeeUseCase {
    private final EmployeeRepository repository;
    private final EventPublisher eventPublisher;

    public DeactivateEmployeeUseCase(EmployeeRepository repository, EventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public GenericResponse execute(String documentValue) {
        boolean exists = repository.existsById(documentValue);
        if (!exists) {
            return new GenericResponse(false, "El empleado no existe");
        }else if(!Document.isValid(documentValue)){
            return new GenericResponse(false, "El documento debe contener unicamente números");
        }

        Document document = Document.of(documentValue);

        Employee employee = repository.findById(document.getValue()).get();

        employee.setStatus(false);

        repository.inactivate(employee.getDocument().getValue());

        employee.getDomainEvents().forEach(eventPublisher::publish);
        employee.clearDomainEvents();

        return new GenericResponse(true, "Empleado inhabilitado correctamente");
    }
}
