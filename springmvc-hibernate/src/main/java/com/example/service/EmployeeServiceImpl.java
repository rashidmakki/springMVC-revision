package com.example.service;

import com.example.dao.EmployeeDAO;
import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDAO employeeDAO;
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    public void deleteEmployee(int id) {
       employeeDAO.deleteEmployee(id);
    }

    public void updateEmployee(Employee employee){ employeeDAO.updateEmployee(employee);}
}
