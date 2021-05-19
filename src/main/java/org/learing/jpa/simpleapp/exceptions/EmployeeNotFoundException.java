package org.learing.jpa.simpleapp.exceptions;

import org.learing.jpa.simpleapp.model.Employee;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String s) {
        super(s);
    }
}
