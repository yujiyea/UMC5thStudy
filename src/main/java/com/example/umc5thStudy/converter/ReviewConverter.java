package com.example.umc5thStudy.converter;

import com.example.umc5thStudy.domain.mapping.Review;
import com.example.umc5thStudy.web.dto.ReviewRequestDTO;
import com.example.umc5thStudy.web.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.ReviewDTO request){
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResultDTO toCreateReviewDTO(Review review){
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
