package com.employees.employeemanagement.controller;

import com.employees.employeemanagement.dao.entity.User;
import com.employees.employeemanagement.dto.request.UserRequestDto;
import com.employees.employeemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /* @RequestMapping(value = "users", produces = "application/json", method = RequestMethod.POST)
     public long saveUser(@RequestBody UserRequestDto newUser) {
          return userService.createNewUser(newUser);
     }*/

    @RequestMapping(value = "users", consumes = "application/json",
            produces = "application/json", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserRequestDto newUser) {
        return userService.createNewUser(newUser);
    }

    @GetMapping("users")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @DeleteMapping("users")
    public void deleteUser(@RequestParam(value = "surname") String surname,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "fatherName") String fatherName) {
        userService.deleteCurrentUser(name, surname, fatherName);
    }

    /*@PutMapping("users")
    public User updateUserDetails(@RequestParam(value = "surname") String surname,
                                  @RequestParam(value = "name") String name,
                                  @RequestParam(value = "fatherName") String fatherName){
        userService.updateUser()
    }*/
    @PutMapping("users")
    public User updateUserDetails(@RequestBody UserRequestDto user) {
        return userService.updateUser(user);
    }
}
