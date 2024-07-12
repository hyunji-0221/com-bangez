package com.bangez.tx.point.repository;

import com.bangez.tx.point.domain.PointModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<PointModel, Long>{
    Optional<PointModel> findByUserId(Long userId);
}
