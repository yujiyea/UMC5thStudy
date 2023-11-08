package com.example.umc5thStudy.domain;

import com.example.umc5thStudy.domain.common.BaseEntity;
import com.example.umc5thStudy.domain.enums.Gender;
import com.example.umc5thStudy.domain.mapping.PreferFood;
import com.example.umc5thStudy.domain.mapping.Review;
import com.example.umc5thStudy.domain.mapping.UserMission;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 15)
    private String phone;
    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(6)")
    private Gender gender;
    private Date birth;
    @Column(nullable = false, length = 100)
    private String address;
    private boolean status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PreferFood> preferFoodList = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> missionList = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

}
