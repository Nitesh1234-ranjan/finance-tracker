package com.example.finance_tracker.mapper;

import com.example.finance_tracker.dto.UserDTO;
import com.example.finance_tracker.model.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User toEntity(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static UserDTO toDTO(User entity) {
        if (entity == null) return null;
        return new UserDTO(entity.getId(), entity.getName(), entity.getEmail());
    }

    public static List<UserDTO> toDTOList(List<User> users) {
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<User> toEntityList(List<UserDTO> userDTOs) {
        return userDTOs.stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());
    }
}
