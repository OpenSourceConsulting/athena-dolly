package com.athena.dolly.controller.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athena.dolly.controller.domain.dto.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {

}
