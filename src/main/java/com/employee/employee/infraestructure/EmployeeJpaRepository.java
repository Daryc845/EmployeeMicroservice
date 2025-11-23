package com.employee.employee.infraestructure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, String>{
}
