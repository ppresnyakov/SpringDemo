package org.ibs.service.rest.v2;

import lombok.extern.slf4j.Slf4j;
import org.ibs.service.EmployeeRepository;
import org.ibs.service.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController("employee controller v2")
@RequestMapping("/v2/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;


    @GetMapping("/getUnderEmplByBossId/{boss_id}")
    Iterable<Employee> getUnderEmplByBossId (@PathVariable Long boss_id){
        return repository.findByBoss_id(boss_id);
    }

    @GetMapping("/getBossByEmplId/{empl_id}")
    Employee getBossByEmplId(@PathVariable Long empl_id)
    {
        Employee emp = repository.findById(empl_id).get();
        Long boss_id = emp.getBoss_id();
        return repository.findById(boss_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getRichBithesById")
    Iterable<Employee> getRichBithesById()
    {
        List <Employee> emp = (List<Employee>) repository.findAll();

        Integer currentSalary;
        Long currentBossId;


        ArrayList <Employee> richBitches = new ArrayList<>();

        for (int i = 0; i < emp.size();i++)
        {
            currentSalary = emp.get(i).getMonthSalary();
            currentBossId =  emp.get(i).getBoss_id();
            for(int j =0;j<emp.size();j++)
            {
                if (currentSalary > emp.get(j).getMonthSalary() && emp.get(i).getBoss_id() == emp.get(j).getId()  ){
                    richBitches.add(emp.get(i));
            }

            }
        }
        return  richBitches;
    }



}
