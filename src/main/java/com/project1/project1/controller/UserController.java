package com.project1.project1.controller;


import com.project1.project1.dto.UserDTO;
import com.project1.project1.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/singUp")
    public void singUp(@RequestBody UserDTO user) {
        userService.registerUser(user);
    }
    @GetMapping("/getUserInfo")
    public <T> ResponseEntity<String> getUserInfo() {
        userService.isDuplicated("Test");
        userService.getUserInfo("TestData");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hi");
    }

}
