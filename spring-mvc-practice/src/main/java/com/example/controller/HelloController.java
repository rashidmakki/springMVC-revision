package com.example.controller;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    EmployeeDao dao;

    @RequestMapping(method = RequestMethod.GET)
    public String display(Model model){
        model.addAttribute("command", new Employee());
        List<Employee> list=dao.getEmployees();
        model.addAttribute("list",list);
        return "hello" ;
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("emp") Employee emp){
        dao.save(emp);
        return "redirect:/hello";
    }

    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "redirect:/hello";
    }

    @RequestMapping(value="/editemp/{id}")
    public String edit(@PathVariable int id, Model m){
        Employee emp = dao.getEmpById(id);
        m.addAttribute("command",emp);
        return "editEmp";
    }

    @RequestMapping(value="/editemp/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("emp") Employee emp){
        dao.update(emp);
        return "redirect:/hello";
    }
}
