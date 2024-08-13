package com.project1.project1.controller;


import com.project1.project1.utils.restResponse.ErrorResponseDto;
import com.project1.project1.dto.UserDTO;
import com.project1.project1.service.UserService;
import com.project1.project1.utils.restResponse.ResponseDto;
import com.project1.project1.utils.restResponse.RestResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ResponseDto> getUserInfo() {
        userService.isDuplicated("Test");
        userService.getUserInfo("TestData");

        List<String> testData = List.of("h1", "h2", "h3", "h4", "h5", "h6");
        //return RestResponseUtil.Success(testData);
        return RestResponseUtil.Fail();
    }
}
