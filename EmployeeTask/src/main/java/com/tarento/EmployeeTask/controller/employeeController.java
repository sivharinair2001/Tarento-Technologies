package com.tarento.EmployeeTask.controller;
import com.tarento.EmployeeTask.entity.employee;
import org.springframework.http.ResponseEntity;
import com.tarento.EmployeeTask.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employees")
public class employeeController {
    @Autowired
    private final employeeService empservice;

    @Autowired
    public employeeController(employeeService empService) {
        this.empservice = empService;
    }
    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

    @GetMapping("/search")
    public ResponseEntity<List<employee>> findByDepartmentAndHireDateYear(@RequestParam String department, @RequestParam int year) {
        List<employee> employees = empservice.findByDepartmentAndHireDateYear(department, year);
        return ResponseEntity.ok(employees);
    }


}
