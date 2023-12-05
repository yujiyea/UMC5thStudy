package com.example.umc5thStudy.service.UserService;

import com.example.umc5thStudy.base.Code;
import com.example.umc5thStudy.base.exception.handler.FoodCategoryHandler;
import com.example.umc5thStudy.converter.UserConverter;
import com.example.umc5thStudy.converter.UserPreferConverter;
import com.example.umc5thStudy.domain.FoodCategory;
import com.example.umc5thStudy.domain.User;
import com.example.umc5thStudy.domain.mapping.PreferFood;
import com.example.umc5thStudy.repository.FoodCategoryRepository;
import com.example.umc5thStudy.repository.UserRepository;
import com.example.umc5thStudy.web.dto.UserRequsetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;


    @Override
    public User joinMember(UserRequsetDTO.JoinDto request) {
        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(Code.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<PreferFood> userPreferList = UserPreferConverter.toMemberPreferList(foodCategoryList);
        userPreferList.forEach(userPrefer -> {userPrefer.setMember(newUser);});

        return userRepository.save(newUser);
    }
}
