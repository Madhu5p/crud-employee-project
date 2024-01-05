package com.madhu.employeecrud.dao;

import com.madhu.employeecrud.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    Employee findById(int theId);
    List<Employee> findALl();
    Employee save(Employee employee);

    void delete(Employee employee);

}
