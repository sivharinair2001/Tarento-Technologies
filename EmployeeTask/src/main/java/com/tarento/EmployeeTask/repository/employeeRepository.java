package com.tarento.EmployeeTask.repository;

import com.tarento.EmployeeTask.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface employeeRepository extends JpaRepository<employee, Long> {
    @Query("SELECT e FROM employee  e WHERE e.department = :department AND EXTRACT(YEAR FROM e.hireDate) = :year")
    List<employee> findByDepartmentAndHireDateYear(@Param("department") String department, @Param("year") int year);
}
