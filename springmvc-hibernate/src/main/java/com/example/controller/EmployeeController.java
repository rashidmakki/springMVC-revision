package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
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
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public String display(Model model){
        model.addAttribute("command", new Employee());
        model.addAttribute("list", employeeService.getEmployees());
        return "hello" ;
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("emp") Employee emp){
        Employee empDetails = employeeService.getEmployee(emp.getId());
        if (empDetails == null) {
            // new employee, add it
            employeeService.saveEmployee(emp);
        } else {
            // existing employee, call update
            employeeService.updateEmployee(emp);
        }
        return "redirect:/hello";
    }

    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "redirect:/hello";
    }

    @RequestMapping(value="/editemp/{id}")
    public String edit(@PathVariable int id, Model m){
        Employee emp =  employeeService.getEmployee(id);
        m.addAttribute("command",emp);
        return "editEmp";
    }

    @RequestMapping(value="/editemp/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("emp") Employee emp){
        employeeService.updateEmployee(emp);
        return "redirect:/hello";
    }


}
