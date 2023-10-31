package com.example.dao;

import com.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements  EmployeeDAO{
    @Autowired
    SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getEmployees(){
        Session session = sessionFactory.getCurrentSession();
        List<Employee> EmployeesList = session.createQuery("from Employee").list();
        return EmployeesList;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        if(null != employee){
            session.delete(employee);
        }
    }
}
