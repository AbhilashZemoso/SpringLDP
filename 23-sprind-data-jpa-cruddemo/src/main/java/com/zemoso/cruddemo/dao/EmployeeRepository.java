package com.zemoso.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zemoso.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
