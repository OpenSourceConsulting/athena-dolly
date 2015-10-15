package com.athena.dolly.controller.web.machine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {

	public List<Machine> findByNameOrSshIPAddr(String name, String sshIPAddr);
}
