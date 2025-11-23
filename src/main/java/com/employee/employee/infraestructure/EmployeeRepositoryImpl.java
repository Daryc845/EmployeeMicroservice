package com.employee.employee.infraestructure;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.employee.employee.domain.Employee;
import com.employee.employee.domain.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final EmployeeJpaRepository jpa;

    public EmployeeRepositoryImpl(EmployeeJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public void create(Employee employee) {
        EmployeeEntity entity = EmployeeEntity.fromDomain(employee);
        jpa.save(entity);
    }

    @Override
    public void update(Employee employee) {
        EmployeeEntity entity = EmployeeEntity.fromDomain(employee);
        jpa.save(entity);
    }

    @Override
    public List<Employee> findAll() {
        return jpa.findAll().stream()
                .map(EmployeeEntity::toDomain)
                .toList();
    }

    @Override
    public void inactivate(String document) {
        Optional<EmployeeEntity> entity = jpa.findById(document);

        if (entity.isPresent()) {
            EmployeeEntity e = entity.get();
            e.setStatus(false);
            jpa.save(e);
        }
    }

    @Override
    public Optional<Employee> findById(String document) {
        return jpa.findById(document)
                  .map(EmployeeEntity::toDomain);
    }

    @Override
    public boolean existsById(String document) {
        return jpa.existsById(document);
    }
}
