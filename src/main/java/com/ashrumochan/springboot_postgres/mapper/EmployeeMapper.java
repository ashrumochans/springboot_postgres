package com.ashrumochan.springboot_postgres.mapper;

import com.ashrumochan.springboot_postgres.dto.EmployeeDto;
import com.ashrumochan.springboot_postgres.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee Employee) {
        return EmployeeDto.builder()
                .id(Employee.getId())
                .name(Employee.getName())
                .email(Employee.getEmail())
                .build();
    }

    public static Employee mapToEmployee(EmployeeDto EmployeeDto) {
        return Employee.builder()
                .id(EmployeeDto.getId())
                .name(EmployeeDto.getName())
                .email(EmployeeDto.getEmail())
                .build();
    }
}