package com.employees.employeemanagement.service;


import com.employees.employeemanagement.dao.entity.User;
import com.employees.employeemanagement.dto.request.UserRequestDto;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    //long createNewUser(UserRequestDto user);

    User createNewUser(UserRequestDto userRequestDto);

    void deleteCurrentUser(String surname,
                           String name,
                           String fatherName);

    User updateUser(UserRequestDto user);
}
