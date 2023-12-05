package com.example.umc5thStudy.converter;


import com.example.umc5thStudy.domain.User;
import com.example.umc5thStudy.domain.enums.Gender;
import com.example.umc5thStudy.web.dto.UserRequsetDTO;
import com.example.umc5thStudy.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequsetDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .birth(request.getBirth())
                .preferFoodList(new ArrayList<>())
                .build();
    }


}
