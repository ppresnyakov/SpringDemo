package org.ibs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)

 class DbTest {
    @PersistenceContext
    EntityManager em;


    @BeforeEach
    void setup() {
        Department department = new Department(136L, "IT");
        Course course = new Course(null, "REST service");

        em.persist(department);
        em.persist(course);
    }

    @Test
    void test(){

    }

}
