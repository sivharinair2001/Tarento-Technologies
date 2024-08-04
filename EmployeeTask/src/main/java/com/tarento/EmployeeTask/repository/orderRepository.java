package com.tarento.EmployeeTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tarento.EmployeeTask.entity.order;

public interface orderRepository extends JpaRepository<order, Long> {
}
