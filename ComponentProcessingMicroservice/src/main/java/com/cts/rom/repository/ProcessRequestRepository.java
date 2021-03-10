package com.cts.rom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.rom.model.ProcessRequest;

@Repository
public interface ProcessRequestRepository extends JpaRepository<ProcessRequest, Integer> {

}
