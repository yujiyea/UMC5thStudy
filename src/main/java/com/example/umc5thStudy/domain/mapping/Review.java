package com.example.umc5thStudy.domain.mapping;

import com.example.umc5thStudy.domain.Restaurant;
import com.example.umc5thStudy.domain.User;
import com.example.umc5thStudy.domain.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(nullable = false)
    private Float score;
    private String image;
    @Column(nullable = false, length = 300)
    private String content;

    @ColumnDefault("0")
    private boolean isDeleted;

    public void setUser(User user){
        if(this.user != null)
            user.getReviewList().remove(this);
        this.user = user;
        user.getReviewList().add(this);
    }

    public void setRestaurant(Restaurant restaurant){
        if (this.score != null)
            restaurant.getReviewList().remove(this);
        this.restaurant = restaurant;
        restaurant.getReviewList().add(this);
    }

}
