package com.ashrumochan.springboot_postgres.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {
    private Integer id;
    private String name;
    private String email;
}
