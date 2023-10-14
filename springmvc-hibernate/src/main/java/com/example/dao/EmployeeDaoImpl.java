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
import java.util.List;

@Repository
public class EmployeeDaoImpl implements  EmployeeDAO{
    @Autowired
    SessionFactory sessionFactory;
    public List<Employee> getEmployees() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery< Employee > cq = cb.createQuery(Employee.class);
        Root< Employee > root = cq.from(Employee.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    public void saveEmployee(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(employee);
    }

    public Employee getEmployee(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Employee employee = currentSession.get(Employee.class, id);
        return employee;
    }

    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.byId(Employee.class).load(id);
        session.delete(employee);
    }
}
