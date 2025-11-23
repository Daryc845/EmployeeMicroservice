package com.employee.employee.domain;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    void create(Employee employee);

    void update(Employee employee);

    List<Employee> findAll();

    void inactivate(String document);

    Optional<Employee> findById(String document);

    boolean existsById(String document);
}
