package org.learing.jpa.simpleapp.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private Long id;
    private String name;
    private String email;
    private String imageUrl;
    private String position;
    private String employeeId;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", position='" + position + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
