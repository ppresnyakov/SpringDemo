package org.ibs.service.rest;

import org.ibs.service.domain.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository <Department, Long> {
}
