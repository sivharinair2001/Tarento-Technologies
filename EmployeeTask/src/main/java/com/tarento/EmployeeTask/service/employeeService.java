package com.tarento.EmployeeTask.service;
import com.tarento.EmployeeTask.entity.employee;
import com.tarento.EmployeeTask.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class employeeService {
    @Autowired
    private final employeeRepository empRepo;

    @Autowired
    public employeeService(employeeRepository empRepo) {
        this.empRepo = empRepo;
    }


    public List<employee> findByDepartmentAndHireDateYear(String department, int year) {
        return empRepo.findByDepartmentAndHireDateYear(department, year);
    }



}
