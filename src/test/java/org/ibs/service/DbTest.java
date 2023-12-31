package org.ibs.service;

import org.ibs.service.domain.entity.Course;
import org.ibs.service.domain.entity.Department;
import org.ibs.service.domain.entity.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
@ActiveProfiles("test")

 class DbTest {
    @PersistenceContext
    EntityManager em;

    @Autowired
    EmployeeRepository employeeRepository;


    @BeforeEach
    void setup() {
    }

    @Test
    void test(){
        Assert.assertEquals(1,em.createQuery("FROM Department").getResultList().size());
        Employee emp = em.createQuery("FROM Employee ", Employee.class)
                .setMaxResults(1)
                .getResultList()
                .get(0);
        Assert.assertEquals("REST service", emp.getCourses().get(0).getName());
    }


    @Test
    void test2(){
    }
}
