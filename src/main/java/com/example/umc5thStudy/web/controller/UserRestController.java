package com.example.umc5thStudy.web.controller;

import com.example.umc5thStudy.base.ResponseDto;
import com.example.umc5thStudy.converter.UserConverter;
import com.example.umc5thStudy.domain.User;
import com.example.umc5thStudy.service.UserService.UserCommandService;
import com.example.umc5thStudy.web.dto.UserRequsetDTO;
import com.example.umc5thStudy.web.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    private final UserCommandService memberCommandService;

    @PostMapping("/")
    public ResponseDto<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequsetDTO.JoinDto request){
        User user = memberCommandService.joinMember(request);
        return ResponseDto.onSuccess(UserConverter.toJoinResultDTO(user));
    }
}
