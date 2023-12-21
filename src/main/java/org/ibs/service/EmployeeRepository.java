package org.ibs.service;

import org.ibs.service.domain.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Long> {

    @Query("select e from Employee e where e.boss_id = ?1")
    Iterable<Employee> findByBoss_id(Long boss_id);

    @Query("select e from Employee e where e.boss_id = ?1")
    Iterable<Employee> show_Boss(Long id);

    List<Employee> findByFirstName(String firstName);



}
