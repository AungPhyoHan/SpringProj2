package com.aph.spring.proj2.springproj2.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.aph.spring.proj2.springproj2.model.Employee;
import com.aph.spring.proj2.springproj2.repository.EmployeeRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping(value = "/employee")
public class employeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    // @PostConstruct
    // public void init(){
    //     Employee e1 = new Employee();
    //     e1.setName("Aung Phyo");
    //     e1.setPosition("IT");
    //     Employee e2 = new Employee();
    //     e2.setName("Okay");
    //     e2.setPosition("IT");
    //     employeeRepo.saveAndFlush(e1);
    //     employeeRepo.saveAndFlush(e2);
    // }

    @GetMapping("/")
    public ModelAndView indexEmployee(ModelAndView mav,@ModelAttribute("employee") Employee employee) {
        Iterable<Employee> employees = employeeRepo.findAll();
        mav.addObject("msg","");
        mav.addObject("employee", employee);
        mav.addObject("employees", employees);
        mav.setViewName("employee");
        return mav;
    }

    @PostMapping("/add")
    public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee,ModelAndView mav) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/DD");
        String currentDate = dateTime.format(formatter);
        // Employee
        System.out.println(employee.getPosition());
        Employee e = new Employee();
        e.setName(employee.getName());
        e.setPosition(employee.getPosition());
        e.setCreatedAt(currentDate);
        employeeRepo.saveAndFlush(e);
        mav.addObject("msg", "Successfully added new one");
        mav.setViewName("redirect:/employee/");
        return mav;
    }
    
    
}
