package com.athena.dolly.controller.web.machine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {
	List<Machine> findBySshIPAddr(String ssh_ipaddr);
	List<Machine> findByName(String name);
}
