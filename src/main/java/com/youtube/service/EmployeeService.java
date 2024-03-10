package com.youtube.service;

import com.youtube.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public String removeEmployee(int id);
    public Optional<Employee> findEmpByID(int id);
    public String updateEmployee(int id);
    public List<Employee> getAllEmployee();
}
