package com.ashrumochan.springboot_postgres.service;

import com.ashrumochan.springboot_postgres.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto EmployeeDto);

    EmployeeDto getEmployeeById(Integer id);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(EmployeeDto employeeDto,Integer id);

    void deleteEmployeeById(Integer id);
}
