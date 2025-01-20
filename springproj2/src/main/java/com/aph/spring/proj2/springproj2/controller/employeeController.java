package com.aph.spring.proj2.springproj2.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.aph.spring.proj2.springproj2.model.Employee;
import com.aph.spring.proj2.springproj2.repository.EmployeeRepo;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping(value = "/employee")
public class employeeController {

    private boolean flag = true;

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

    @GetMapping("/return")
    public ModelAndView backAndCancel(ModelAndView mav){
        mav.setViewName("redirect:/employee/");
        return mav;
    }

    @GetMapping("/")
    public ModelAndView indexEmployee(ModelAndView mav,@ModelAttribute("employee") Employee employee) {
        Iterable<Employee> employees = employeeRepo.findAll();
        mav.addObject("employee", employee);
        mav.addObject("employees", employees);
        mav.addObject("flag", flag);
        mav.setViewName("employee");
        return mav;
    }

    @PostMapping("/add")
    @Transactional
    public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee,ModelAndView mav) {
        String currentDate = getCurrentDateTime();
        // Employee
        Employee e = new Employee();
        e.setName(employee.getName());
        e.setPosition(employee.getPosition());
        e.setCreatedAt(currentDate);
        employeeRepo.saveAndFlush(e);
        mav.setViewName("redirect:/employee/");
        return mav;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdate(@PathVariable("id") Long id,ModelAndView mav)
    {
        flag = false;
        Optional<Employee> employee = employeeRepo.findById(id);
        mav.addObject("employee", employee.get());
        mav.setViewName("employee");
        return mav;
    }

    @PostMapping("/update")
    @Transactional
    public ModelAndView update(@ModelAttribute("employee") Employee employee,ModelAndView mav){
        String currentDate = getCurrentDateTime();
        employee.setUpdatedAt(currentDate);
        employeeRepo.saveAndFlush(employee);
        mav.setViewName("redirect:/employee/");
        return mav;
    }

    String getCurrentDateTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/DD");
        String currentDate = dateTime.format(formatter);
        return currentDate;
    }
    
    
}
