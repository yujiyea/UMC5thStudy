package com.example.umc5thStudy.service.UserService;

import com.example.umc5thStudy.domain.User;
import com.example.umc5thStudy.web.dto.UserRequsetDTO;

public interface UserCommandService {
    User joinMember(UserRequsetDTO.JoinDto request);
}
