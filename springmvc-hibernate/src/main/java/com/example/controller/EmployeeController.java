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
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView display(){
        List<Employee> list = employeeService.getEmployees();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("command", new Employee());
        model.put("list", list);
        for( Employee employee : list){
            System.out.println(employee.getId() + ' ' +employee.getEmail() + ' ' + employee.getName() );
        }
        return new ModelAndView("hello",model) ;
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("emp") Employee emp){
        employeeService.saveEmployee(emp);
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
        employeeService.saveEmployee(emp);
        return "redirect:/hello";
    }


}
