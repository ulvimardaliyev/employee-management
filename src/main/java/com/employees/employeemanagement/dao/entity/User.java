package com.employees.employeemanagement.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private int user_id;
    private String name;
    private String surname;
    private String fatherName;
    private String birthday;
    private String position;
    private String finCode;
}
