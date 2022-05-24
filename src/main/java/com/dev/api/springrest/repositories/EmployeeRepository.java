package com.dev.api.springrest.repositories;


import com.dev.api.springrest.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
