package com.example.flightservicemanagementtransaction.repository;

import com.example.flightservicemanagementtransaction.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}
