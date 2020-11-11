package com.zemoso.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zemoso.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
