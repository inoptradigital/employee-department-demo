package com.inoptra.employeedepartmentdemo.controllers;

import com.inoptra.employeedepartmentdemo.services.AccountStatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 **/

@RestController
@RequestMapping("/account/accountstats")
@Slf4j
@RequiredArgsConstructor
public class AccountStatisticsController {

    private final AccountStatisticsService accountStatisticsService;

    @GetMapping("/all/total")
    public ResponseEntity<Double> getTotalSalaryForAllDepartments() {
        return ResponseEntity.ok(accountStatisticsService.getTotalSalaryForAllDepartments());
    }

    @GetMapping("/{deptId}/total")
    public ResponseEntity<Double> getTotalSalaryForDepartment(@PathVariable long deptId) {
        accountStatisticsService.getTotalSalaryForDepartment(deptId);
        return ResponseEntity.ok(accountStatisticsService.getTotalSalaryForDepartment(deptId));
    }

    @GetMapping("/all/avg")
    public ResponseEntity<Double> getAverageSalaryForAllDepartments() {
        return ResponseEntity.ok(accountStatisticsService.getAverageSalaryForAllDepartments());

    }

    @GetMapping("/{deptId}/avg")
    public ResponseEntity<Double> getAverageSalaryForDepartment(@PathVariable long deptId) {
        return ResponseEntity.ok(accountStatisticsService.getAverageSalaryForDepartment(deptId));
    }
}
