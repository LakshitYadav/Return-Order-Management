package com.cts.rom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.rom.model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
