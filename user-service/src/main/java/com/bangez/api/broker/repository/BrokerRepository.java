package com.bangez.api.broker.repository;

import com.bangez.api.broker.domain.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrokerRepository extends JpaRepository<Broker, Long> {
}
