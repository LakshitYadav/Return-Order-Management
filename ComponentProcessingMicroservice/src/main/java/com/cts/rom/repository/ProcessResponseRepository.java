package com.cts.rom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.rom.model.ProcessResponse;

@Repository
public interface ProcessResponseRepository extends JpaRepository<ProcessResponse, Integer> {
	
}
