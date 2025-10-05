package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.UserDTO;
import com.example.finance_tracker.mapper.UserMapper;
import com.example.finance_tracker.model.User;
import com.example.finance_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);

        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        user = userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return UserMapper.toDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existing = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existing.setName(userDTO.getName());
        existing.setEmail(userDTO.getEmail());
        existing = userRepository.save(existing);
        return UserMapper.toDTO(existing);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean validateUser(String email, String password) {
        return userRepository.findByEmail(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}
