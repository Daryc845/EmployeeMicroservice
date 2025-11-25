package com.employee.employee.infraestructure.adapters.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

@Component
public class EmployeeEventProducer {
    private static final String TOPIC_EMPLOYEE_VALIDATED = "employee_validated_events";
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public EmployeeEventProducer(KafkaTemplate<String, String> kafkaTemplate, 
                               ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendEmployeeValidatedEvent(Long requestId, String employeeId, 
                                         String accessdatetime, String requestType, 
                                         String status) {
        try {
            Map<String, Object> eventPayload = Map.of(
                "requestId", requestId,
                "employeeId", employeeId,
                "accessdatetime", accessdatetime,
                "requestType", requestType,
                "status", status,
                "eventType", "EMPLOYEE_VALIDATION_RESULT"
            );
            
            String json = objectMapper.writeValueAsString(eventPayload);
            kafkaTemplate.send(TOPIC_EMPLOYEE_VALIDATED, json);
            
        } catch (Exception e) {
            System.err.println("Error enviando evento de validación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}