package com.example.finance_tracker.controller;

import com.example.finance_tracker.constants.ApiPaths;
import com.example.finance_tracker.dto.UserDTO;
import com.example.finance_tracker.orchestration.OrchestrationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
