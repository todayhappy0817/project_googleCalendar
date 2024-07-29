package com.project1.project1.service;

import com.project1.project1.dto.UserDTO;
import org.apache.catalina.User;

public interface UserService {
    void registerUser(UserDTO userDto);
    UserDTO login(String id,String Password);
    boolean logout(String id);
    boolean changePassword(String id, String oldPassword, String newPassword);
    boolean isDuplicated(String id);
    UserDTO getUserInfo(String id);
}
