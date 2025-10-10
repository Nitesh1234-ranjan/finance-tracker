package com.example.finance_tracker.controller;

import com.example.finance_tracker.constants.ApiPaths;
import com.example.finance_tracker.dto.UserDTO;
import com.example.finance_tracker.orchestration.OrchestrationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(ApiPaths.USERS)
public class UserController {

    private final OrchestrationInterface orchestration;

    @Autowired
    public UserController(OrchestrationInterface orchestration) {
        this.orchestration = orchestration;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return orchestration.createUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return orchestration.getAllUsers();
    }

    @GetMapping(ApiPaths.USER_BY_ID)
    public UserDTO getUserById(@PathVariable Long id) {
        return orchestration.getUserById(id);
    }

    @PutMapping(ApiPaths.USER_BY_ID)
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return orchestration.updateUser(id, userDTO);
    }

    @DeleteMapping(ApiPaths.USER_BY_ID)
    public void deleteUser(@PathVariable Long id) {
        orchestration.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        boolean valid = orchestration.validateUser(userDTO.getEmail(), userDTO.getPassword());
        if(valid) {
            // optionally generate JWT token
            return ResponseEntity.ok(Map.of("message", "Login successful", "token", "dummy-jwt"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));
        }
    }
}
