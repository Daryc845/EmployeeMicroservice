package com.employee.employee.infraestructure;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeJpaRepository extends MongoRepository<EmployeeEntity, String> {
}
