package org.learing.jpa.simpleapp.repository;

import org.learing.jpa.simpleapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
