package com.sb.service;

import com.sb.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(Integer employeeId);

    public Employee updateEmployee(Employee employee);

    public Employee getEmployee(int employeeId);
}
