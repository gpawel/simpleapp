package org.qamation.simpleapp.model;


import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String imageUrl;
    private String position;
    @Column(nullable = false, updatable = false)
    private String employeeCode;
}
