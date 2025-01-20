package com.aph.spring.proj2.springproj2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aph.spring.proj2.springproj2.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    
}
