package com.employees.employeemanagement.dao.repository;

import com.employees.employeemanagement.dao.entity.User;

import java.util.List;


public interface UserRepository {

    List<User> findAllUsers();

    //long insertNewUser(User newUser);
    User insertNewUser(User newUser);

    void deleteUser(String surname, String name, String fatherName);

    void deleteUserById(int userId);

    User updateUser();
}
