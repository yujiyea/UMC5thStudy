package com.example.umc5thStudy.web.controller;

import com.example.umc5thStudy.base.ResponseDto;
import com.example.umc5thStudy.converter.ReviewConverter;
import com.example.umc5thStudy.domain.mapping.Review;
import com.example.umc5thStudy.service.reviewService.ReviewCommandService;
import com.example.umc5thStudy.web.dto.ReviewRequestDTO;
import com.example.umc5thStudy.web.dto.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    @PostMapping("/reviews")
    public ResponseDto<ReviewResponseDTO.CreateReviewResultDTO> review(@RequestBody @Valid ReviewRequestDTO.ReviewDTO request, @RequestParam(name="memberId") Long memberId){
        Review review = reviewCommandService.createReview(memberId,request);
        return ResponseDto.onSuccess(ReviewConverter.toCreateReviewDTO(review));
    }
}
