package org.ibs.service.rest;

import ch.qos.logback.core.model.conditional.ElseModel;
import io.swagger.v3.oas.annotations.Operation;
import org.ibs.service.bussines.SalaryService;
import org.ibs.service.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v2/salary/max/")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("/max/department/{departmentId}")
    @Operation(operationId = "maxSalaryEmployeeDep", summary = "Get max salary emploee")
    Employee maxSalaryEmployeeDepartment(@PathVariable Long departmentId){
        return salaryService.maxSalaryEmployeeInDepartment(departmentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dep or Empl not found."));
    }

}
