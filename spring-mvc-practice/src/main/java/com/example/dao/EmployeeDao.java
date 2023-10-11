package com.example.dao;

import com.example.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public void setTemplate(JdbcTemplate template) {
        this.jdbcTemplate= template;
    }

    public int save(Employee emp){
        String sql="insert into Employee(name,email) values('"+emp.getName()+"','"+emp.getEmail()+"')";
        return jdbcTemplate.update(sql);
    }

    public int update(Employee emp){
        String sql="update Employee set name='"+emp.getName()+"',email='"+emp.getEmail()+"' where email='"+emp.getEmail()+"'";
        return jdbcTemplate.update(sql);
    }

    public int delete(int id){
        String sql="delete From Employee where id="+id+"";
        return jdbcTemplate.update(sql);
    }

    public Employee getEmpById(int id){
        String sql="select * from Employee where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
    }
    public List<Employee> getEmployees(){
        return jdbcTemplate.query("select * from Employee",new RowMapper<Employee>(){
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee e=new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setEmail(rs.getString(3));
                return e;
            }
        });
    }

}
