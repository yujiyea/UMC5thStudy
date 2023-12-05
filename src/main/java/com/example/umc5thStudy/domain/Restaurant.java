package com.example.umc5thStudy.domain;

import com.example.umc5thStudy.domain.common.BaseEntity;
import com.example.umc5thStudy.domain.mapping.Review;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

    @Column(nullable = false, length = 45)
    private String name;
    private String image;
    @Column(nullable = false, length = 15)
    private String city;
    @Column(nullable = false, length = 15)
    private String town;
    @Column(nullable = false, length = 15)
    private String dong;

    @ColumnDefault("0")
    private boolean isDeleted;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

}
