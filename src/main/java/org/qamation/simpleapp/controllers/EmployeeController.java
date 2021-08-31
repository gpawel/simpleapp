package org.qamation.simpleapp.controllers;

import org.qamation.simpleapp.model.Employee;
import org.qamation.simpleapp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee emp  = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmpl = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmpl,HttpStatus.CREATED);
    }

    @PostMapping("/add/all")
    public ResponseEntity<List<Employee>> addAllEmployee(@RequestBody List<Employee> employees) {
        List<Employee> newEmployees = employeeService.addEmployees(employees);
        return new ResponseEntity<>(newEmployees,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmpl = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmpl,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<Employee> deleteEmployeeB(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }




}
