package com.employee.employee.infraestructure.adapters.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.employee.employee.domain.ports.in.ValidateEmployeeUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

@Component
public class AccessRequestConsumer {

    private final ValidateEmployeeUseCase validateEmployeeUseCase;
    private final EmployeeEventProducer employeeEventProducer;
    private final ObjectMapper objectMapper;

    public AccessRequestConsumer(ValidateEmployeeUseCase validateEmployeeUseCase,
                               EmployeeEventProducer employeeEventProducer,
                               ObjectMapper objectMapper) {
        this.validateEmployeeUseCase = validateEmployeeUseCase;
        this.employeeEventProducer = employeeEventProducer;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "access_request_events")
    public void consumeAccessRequest(String message) {
        try {
            System.out.println("📥 Recibiendo petición de acceso: " + message);
            
            Map<String, Object> event = objectMapper.readValue(message, Map.class);
            
            Long requestId = Long.parseLong(event.get("requestId").toString());
            String employeeId = event.get("employeeId").toString();
            String accessdatetime = event.get("accessdatetime").toString();
            String requestType = event.get("requestType").toString();
            boolean isValid = validateEmployeeUseCase.validateEmployee(employeeId);
            
            if (isValid) {
                employeeEventProducer.sendEmployeeValidatedEvent(
                    requestId, employeeId, accessdatetime, requestType, "APPROVED"
                );
            } else {
                employeeEventProducer.sendEmployeeValidatedEvent(
                    requestId, employeeId, accessdatetime, requestType, "REJECTED"
                );
            }
            
        } catch (Exception e) {
            System.err.println("Error procesando petición de acceso: " + e.getMessage());
            e.printStackTrace();
        }
    }
}