package com.example.umc5thStudy.web.dto;

import com.example.umc5thStudy.validation.annotation.ExistCategories;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class UserRequsetDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        private String name;
        @NotNull
        private String email;
        @NotNull
        private String phone;
        @NotNull
        private Integer gender;
        @NotNull
        private Date birth;
        @Size(min = 5, max = 30)
        private String address;
        @ExistCategories
        List<Long> preferCategory;
    }
}
