package com.example.umc5thStudy.domain.mapping;

import com.example.umc5thStudy.domain.FoodCategory;
import com.example.umc5thStudy.domain.User;
import com.example.umc5thStudy.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "prefer_food")
public class PreferFood extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private FoodCategory foodCategory;
}
