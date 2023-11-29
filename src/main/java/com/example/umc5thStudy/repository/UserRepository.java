package com.example.umc5thStudy.repository;

import com.example.umc5thStudy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
