package com.employees.employeemanagement.dao.repository.impl;

import com.employees.employeemanagement.dao.entity.User;
import com.employees.employeemanagement.dao.repository.UserRepository;
import com.employees.employeemanagement.dbconnection.CreateDatabaseConnection;
import com.employees.employeemanagement.dbconnection.QueryExecutor;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private CreateDatabaseConnection connection;

    @Override
    public List<User> findAllUsers() {
        QueryExecutor queryExecutor = new QueryExecutor();
        return queryExecutor.selectAllUsers();
    }

    @Override
    public User insertNewUser(User newUser) {
        QueryExecutor queryExecutor = new QueryExecutor();
        return queryExecutor.insertUser1(newUser);
    }

   /* @Override
    public long insertNewUser(User newUser) {
        Select select = new Select();
        return select.insertUser(newUser);
    }*/


    @Override
    public void deleteUser(String surname, String name, String fatherName) {
        QueryExecutor queryExecutor = new QueryExecutor();
        int userId = queryExecutor.findUserByParameters(surname, name, fatherName);
        deleteUserById(userId);
    }

    @Override
    public void deleteUserById(int userId) {
        QueryExecutor queryExecutor = new QueryExecutor();
        queryExecutor.deleteUserById(userId);
    }

    @Override
    public User updateUser() {
        return null;
    }
}