package org.learing.jpa.simpleapp.service;

import org.learing.jpa.simpleapp.model.Employee;
import org.learing.jpa.simpleapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) return emp.get();
        throw new RuntimeException("Unable to find an employee by id: "+id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
