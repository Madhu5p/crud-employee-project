package com.madhu.employeecrud.dao;

import com.madhu.employeecrud.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeDAOImpl extends AbstractDAO implements EmployeeDAO{
    @Override
    public Employee findById(int theId) {
        return getSession().get(Employee.class,theId);
    }


    @Override
    public Employee save(Employee employee) {
        getSession().save(employee);
        return employee;
    }
    @Override
    public void delete(Employee employee) {
        try {
            Session session = getSession();
            session.delete(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Employee> findALl() {
        Criteria criteria=getSession().createCriteria(Employee.class);
        return criteria.list();
    }




}
