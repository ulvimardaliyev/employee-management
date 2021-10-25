package com.employees.employeemanagement.dbconnection;


import com.employees.employeemanagement.dao.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryExecutor {

    private static final Connection DB_CONNECTION = CreateDatabaseConnection.createConnection();

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        CallableStatement callableStatement;

        ResultSet resultSet;
        try {
            callableStatement = DB_CONNECTION.prepareCall("call GetAllUsers");
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String fatherName = resultSet.getString("fatherName");
                String birthday = resultSet.getString("birthday");
                String position = resultSet.getString("position");
                String finCode = resultSet.getString("finCode");
                User user =
                        User
                                .builder()
                                .user_id(user_id)
                                .surname(surname)
                                .name(name)
                                .fatherName(fatherName)
                                .birthday(birthday)
                                .position(position)
                                .finCode(finCode)
                                .build();
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public long insertUser(User newUser) {
        //CallableStatement preparedStatement;
        String query = "insert into user(surname, name, fatherName, birthday, position, finCode)" +
                " values(?,?,?,?,?,?)";
        long id = 0;
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = DB_CONNECTION.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            //preparedStatement = DB_CONNECTION.prepareCall("call InsertUser(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, newUser.getSurname());
            preparedStatement.setString(2, newUser.getName());
            preparedStatement.setString(3, newUser.getFatherName());
            preparedStatement.setString(4, newUser.getBirthday());
            preparedStatement.setString(5, newUser.getPosition());
            preparedStatement.setString(6, newUser.getFinCode());
            //preparedStatement.registerOutParameter(7, Types.INTEGER);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return id;
    }

    public int findUserByParameters(String name, String surname, String fatherName) {
        String query = "SELECT user_id from user Where surname=? and name=? and fatherName=?";
        int id = 0;
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = DB_CONNECTION.prepareStatement(query);

            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, fatherName);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("user_id");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return id;
    }

    public void deleteUserById(int id) {
        String query = "DELETE FROM user Where user_id=?";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = DB_CONNECTION.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public User insertUser1(User newUser) {

        //CallableStatement preparedStatement;
        String query = "insert into user(surname, name, fatherName, birthday, position, finCode)" +
                " values(?,?,?,?,?,?)";
        int id = 0;

        ResultSet resultSet;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = DB_CONNECTION.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            //preparedStatement = DB_CONNECTION.prepareCall("call InsertUser(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, newUser.getSurname());
            preparedStatement.setString(2, newUser.getName());
            preparedStatement.setString(3, newUser.getFatherName());
            preparedStatement.setString(4, newUser.getBirthday());
            preparedStatement.setString(5, newUser.getPosition());
            preparedStatement.setString(6, newUser.getFinCode());
            //preparedStatement.registerOutParameter(7, Types.INTEGER);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return findUserById(id);
    }

    public User findUserById(int userId) {
        String selectQuery = "SELECT * from user where user_id=?";
        String surname = null;
        String name = null;
        String fatherName = null;
        String birthday = null;
        String position = null;
        String finCode = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = DB_CONNECTION.prepareStatement(selectQuery);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                surname = resultSet.getString("surname");
                name = resultSet.getString("name");
                fatherName = resultSet.getString("fatherName");
                birthday = resultSet.getString("birthday");
                position = resultSet.getString("position");
                finCode = resultSet.getString("finCode");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return User
                .builder()
                .name(name)
                .surname(surname)
                .fatherName(fatherName)
                .birthday(birthday)
                .position(position)
                .finCode(finCode)
                .build();
    }
}

/* surname = resultSet.getString("surname");
                name = resultSet.getString("name");
                fatherName = resultSet.getString("fatherName");
                birthday = resultSet.getString("birthday");
                position = resultSet.getString("position");
                finCode = resultSet.getString("finCode");*/
