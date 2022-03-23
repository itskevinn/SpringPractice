package com.kevcode.springpractice.application.employee.services.implementations;

import com.kevcode.springpractice.application.employee.dto.EmployeeDto;
import com.kevcode.springpractice.application.employee.request.EmployeeRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {
    ResponseEntity save(EmployeeRequest employee);

    ResponseEntity<List<EmployeeDto>> getAll();

    ResponseEntity<EmployeeDto> getById(Long id);
}
