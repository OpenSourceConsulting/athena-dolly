package com.athena.dolly.controller.web.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasourceRepository extends
		JpaRepository<Datasource, Integer> {

}
