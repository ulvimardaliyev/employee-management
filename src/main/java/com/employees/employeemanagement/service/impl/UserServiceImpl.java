package com.employees.employeemanagement.service.impl;


import com.employees.employeemanagement.dao.entity.User;
import com.employees.employeemanagement.dao.repository.UserRepository;
import com.employees.employeemanagement.dto.request.UserRequestDto;
import com.employees.employeemanagement.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public User createNewUser(UserRequestDto userRequestDto) {
        User user = User
                .builder()
                .name(userRequestDto.getName())
                .surname(userRequestDto.getSurname())
                .fatherName(userRequestDto.getFatherName())
                .birthday(userRequestDto.getBirthday())
                .finCode(userRequestDto.getFinCode())
                .position(userRequestDto.getPosition())
                .build();
        return userRepository.insertNewUser(user);
    }

    /*@Override
    public long createNewUser(UserRequestDto userRequestDto) {
        User user = User
                .builder()
                .name(userRequestDto.getName())
                .surname(userRequestDto.getSurname())
                .fatherName(userRequestDto.getFatherName())
                .birthday(userRequestDto.getBirthday())
                .finCode(userRequestDto.getFinCode())
                .position(userRequestDto.getPosition())
                .build();
        return userRepository.insertNewUser(user);
    }*/

    @Override
    public void deleteCurrentUser(String surname, String name, String fatherName) {
        userRepository.deleteUser(surname, name, fatherName);
    }

    @Override
    public User updateUser(UserRequestDto user) {
        return null;
    }
}
