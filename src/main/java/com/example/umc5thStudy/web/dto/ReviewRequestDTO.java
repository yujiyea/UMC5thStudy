package com.example.umc5thStudy.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewDTO {
        @NotNull
        private Float score;
        @NotBlank
        private String content;

        private Long restaurantId;

    }

}
