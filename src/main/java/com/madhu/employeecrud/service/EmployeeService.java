package com.madhu.employeecrud.service;

import com.madhu.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(int theId);
    List<Employee> findAll();
    Employee save(Employee employee);
    void delete(Employee employee);



}
