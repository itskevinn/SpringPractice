package com.kevcode.springpractice.application.employee.services.interfaces;

import com.kevcode.springpractice.application.employee.dto.EmployeeDto;
import com.kevcode.springpractice.application.employee.request.EmployeeRequest;
import com.kevcode.springpractice.application.employee.services.implementations.IEmployeeService;
import com.kevcode.springpractice.domain.entities.Customer;
import com.kevcode.springpractice.domain.entities.Employee;
import com.kevcode.springpractice.infrastructure.repository.EmployeeHibernateRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    ModelMapper _modelMapper;
    @Autowired
    EmployeeHibernateRepository _employeeHibernateRepository;

    @Override
    public ResponseEntity<EmployeeDto> save(EmployeeRequest employeeRequest) {
        Employee employee = _modelMapper.map(employeeRequest, Employee.class);
        _employeeHibernateRepository.save(employee);
        EmployeeDto employeeDto = _modelMapper.map(employee, EmployeeDto.class);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EmployeeDto>> getAll() {
        try {
            List<Employee> employees = _employeeHibernateRepository.getAll();
            final List<EmployeeDto> employeeDtos = _modelMapper.map(employees, new TypeToken<List<Customer>>() {
            }.getType());
            return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<EmployeeDto> getById(Long id) {
        try {
            Employee employee = _employeeHibernateRepository.getById(id);
            if (employee == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            EmployeeDto employeeDto = _modelMapper.map(employee, EmployeeDto.class);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
