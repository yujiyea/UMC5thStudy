package com.example.umc5thStudy.converter;

import com.example.umc5thStudy.domain.FoodCategory;
import com.example.umc5thStudy.domain.mapping.PreferFood;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<PreferFood> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        PreferFood.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
