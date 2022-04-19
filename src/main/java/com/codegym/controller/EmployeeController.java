package com.codegym.controller;


import com.codegym.model.Employee;
import com.codegym.service.EmployeeService;
import com.codegym.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final IEmployeeService employeeService = new EmployeeService();

    @GetMapping()
    public ModelAndView getAllEmployee(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Employee> employeeList =employeeService.findAll();
        modelAndView.addObject("employees",employeeList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showForm(ModelMap modelMap) {
    modelMap.addAttribute("employees",new Employee());
    return "/create";
    }

    @PostMapping("/create")
    public String submit(Employee employee){
        employee.setId((int) (Math.random() * 10000));
        employeeService.save(employee);
        return "redirect:/employee";
    }
}


