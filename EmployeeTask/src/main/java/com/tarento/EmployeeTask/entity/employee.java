package com.tarento.EmployeeTask.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employee")
@ToString

public class employee {
    @Id
    private Long id;
    private String name;
    private String department;
    private LocalDate hireDate;

    public employee(Long id, String name, String department, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.hireDate = hireDate;
    }

    //Adding Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long emp_id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
