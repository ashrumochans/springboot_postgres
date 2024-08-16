package com.ashrumochan.springboot_postgres.service.impl;

import com.ashrumochan.springboot_postgres.dto.EmployeeDto;
import com.ashrumochan.springboot_postgres.entity.Employee;
import com.ashrumochan.springboot_postgres.exception.EmployeeNotFoundException;
import com.ashrumochan.springboot_postgres.mapper.EmployeeMapper;
import com.ashrumochan.springboot_postgres.repository.EmployeeRepository;
import com.ashrumochan.springboot_postgres.service.EmployeeService;
import com.ashrumochan.springboot_postgres.util.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(ErrorMessages.EMPLOYEE_NOT_FOUND + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee -> EmployeeMapper.mapToEmployeeDto(employee)))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(ErrorMessages.EMPLOYEE_NOT_FOUND + id));
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(ErrorMessages.EMPLOYEE_NOT_FOUND + id));
       employeeRepository.deleteById(id);
    }
}
