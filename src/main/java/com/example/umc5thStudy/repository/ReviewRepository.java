package com.example.umc5thStudy.repository;

import com.example.umc5thStudy.domain.mapping.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
