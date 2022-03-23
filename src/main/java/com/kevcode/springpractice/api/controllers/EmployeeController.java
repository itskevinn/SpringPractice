package com.kevcode.springpractice.api.controllers;

import com.kevcode.springpractice.application.employee.dto.EmployeeDto;
import com.kevcode.springpractice.application.employee.services.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService _employeeService;

    @GetMapping("/Employees")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return _employeeService.getAll();
    }

    @GetMapping("/Employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        return _employeeService.getById(id);
    }
}
