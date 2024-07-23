package com.bangez.api.user.service;


import com.bangez.api.common.MessengerVO;
import com.bangez.api.user.domain.User;
import com.bangez.api.user.domain.UserDTO;

public interface UserService {

    default UserDTO entityToDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .passwordConfirm(user.getPasswordConfirm())
                .name(user.getName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }

    default User dtoToEntity(UserDTO dto){
        return User.builder()
                .id(dto.getId())
                .userName(dto.getUserName())
                .password(dto.getPassword())
                .passwordConfirm(dto.getPasswordConfirm())
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .build();
    }

    MessengerVO save(UserDTO t);
}