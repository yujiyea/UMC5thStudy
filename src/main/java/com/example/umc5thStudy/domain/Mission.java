package com.example.umc5thStudy.domain;

import com.example.umc5thStudy.domain.common.BaseEntity;
import com.example.umc5thStudy.domain.mapping.UserMission;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private String content;
    private String reward;
    private Date deadline;
    @ColumnDefault("0")
    private boolean isDeleted;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();
}
