package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.UserDTO;
import java.util.List;

public interface UserServiceInterface {
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    boolean validateUser(String email, String password);
}
