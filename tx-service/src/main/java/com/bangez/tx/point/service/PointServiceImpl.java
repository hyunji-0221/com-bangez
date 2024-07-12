package com.bangez.tx.point.service;

import com.bangez.tx.point.domain.PointModel;
import com.bangez.tx.point.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class PointServiceImpl {

    private final PointRepository pointRepository;

    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd/HH:mm:ss");

    public void savePoint(BigDecimal amount, Long userId) {
        PointModel model = pointRepository.findByUserId(userId).orElseGet(null);
        int point = model.getPoint();
        int intAmount = amount.intValue();
        point += intAmount / 500;
        if(intAmount % 500 != 0){
            throw new IllegalArgumentException("500원 단위로 결제해주세요.");
        }else{
            PointModel pointModel = PointModel.builder()
                    .pointId(model.getPointId())
                    .point(point)
                    .userId(userId)
                    .lastChargeDate(date.format(formatter))
                    .build();
            pointRepository.save(pointModel);
        }
    }

    public Optional<PointModel> getPointDetail(Long id) {
        return pointRepository.findByUserId(id);
    }

    public PointModel deductionPoint(Long userId) {
        int deductedPoint = 0;
        PointModel point = pointRepository.findByUserId(userId).orElseGet(null);
        if(point.getPoint() <= 0) {
            throw new IllegalArgumentException("포인트가 부족합니다.");
        }else {
            deductedPoint = point.getPoint() - 1;
        }
        return pointRepository.save(PointModel.builder()
                .pointId(point.getPointId())
                .userId(userId)
                .point(deductedPoint)
                .lastChargeDate(date.format(formatter))
                .build());
    }
}
