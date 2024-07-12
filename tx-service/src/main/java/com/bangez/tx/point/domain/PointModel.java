package com.bangez.tx.point.domain;

import jakarta.persistence.*;
import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "points")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PointModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointId;

    private int point;

    private String lastChargeDate;

    private Long userId;
}
