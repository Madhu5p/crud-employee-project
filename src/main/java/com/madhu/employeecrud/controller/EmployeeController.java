package com.madhu.employeecrud.controller;

import com.madhu.employeecrud.entity.Employee;
import com.madhu.employeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{theId}")
    public Employee getEmployeeById(@PathVariable int theId) {
        return employeeService.findById(theId);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);
        return new ResponseEntity<Object>("Successfully saved", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Employee> getAllDetails() {
        return employeeService.findAll();
    }
    @PutMapping("/update/{theId}")
    public ResponseEntity<Object> updateEmployee(@PathVariable int theId ,@RequestBody Employee employee){
         Employee dbEmployee=employeeService.findById(theId);
        if(dbEmployee==null){
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
        }
        dbEmployee.setFirstName(employee.getFirstName());
        dbEmployee.setLastName(employee.getLastName());
        dbEmployee.setEmail(employee.getEmail());

        employeeService.save(dbEmployee);
        return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{theId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable int theId){
      Employee theEmployee=employeeService.findById(theId);
      employeeService.delete(theEmployee);
      return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }

}
