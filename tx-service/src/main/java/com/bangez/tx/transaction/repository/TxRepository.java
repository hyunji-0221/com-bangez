package com.bangez.tx.transaction.repository;

import com.bangez.tx.transaction.domain.TxModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxRepository extends JpaRepository<TxModel, Long> {
}
