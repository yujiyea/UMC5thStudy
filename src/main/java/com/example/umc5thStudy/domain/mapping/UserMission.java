package com.example.umc5thStudy.domain.mapping;

import com.example.umc5thStudy.domain.Mission;
import com.example.umc5thStudy.domain.Restaurant;
import com.example.umc5thStudy.domain.User;
import com.example.umc5thStudy.domain.common.BaseEntity;
import com.example.umc5thStudy.domain.enums.MissionStatus;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private String reward;
    private Date date;
    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ColumnDefault("0")
    private boolean is_deleted;

}
