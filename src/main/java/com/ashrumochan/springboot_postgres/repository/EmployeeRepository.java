package com.ashrumochan.springboot_postgres.repository;

import com.ashrumochan.springboot_postgres.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

