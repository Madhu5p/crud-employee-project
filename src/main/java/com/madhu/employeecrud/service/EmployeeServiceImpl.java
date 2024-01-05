package com.madhu.employeecrud.service;
import com.madhu.employeecrud.dao.EmployeeDAO;
import com.madhu.employeecrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
     @Autowired
    private  EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    public Employee save(Employee employee) {
        employeeDAO.save(employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findALl();
    }
    @Override
    public void delete(Employee employee) {
        employeeDAO.delete(employee);
    }


}
