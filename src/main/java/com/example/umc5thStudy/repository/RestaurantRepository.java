package com.example.umc5thStudy.repository;

import com.example.umc5thStudy.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
