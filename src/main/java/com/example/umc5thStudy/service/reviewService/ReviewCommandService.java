package com.example.umc5thStudy.service.reviewService;

import com.example.umc5thStudy.converter.ReviewConverter;
import com.example.umc5thStudy.domain.mapping.Review;
import com.example.umc5thStudy.repository.RestaurantRepository;
import com.example.umc5thStudy.repository.ReviewRepository;
import com.example.umc5thStudy.repository.UserRepository;
import com.example.umc5thStudy.web.dto.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public Review createReview(Long userId, ReviewRequestDTO.ReviewDTO request){
        Review review = ReviewConverter.toReview(request);

        review.setUser(userRepository.findById(userId).get());
        review.setRestaurant(restaurantRepository.findById(request.getRestaurantId()).get());

        return reviewRepository.save(review);
    }
}
