package com.employee.detail.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.detail.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
