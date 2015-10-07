package com.athena.dolly.controller.machine.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMachineRepository extends JpaRepository<Machine, Integer> {

}
