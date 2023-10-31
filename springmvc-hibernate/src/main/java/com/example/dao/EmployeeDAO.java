package com.example.dao;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getEmployees();

    public void updateEmployee(Employee employee);

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
