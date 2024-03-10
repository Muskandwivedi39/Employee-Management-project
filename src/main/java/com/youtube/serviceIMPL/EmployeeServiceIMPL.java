package com.youtube.serviceIMPL;

import com.youtube.model.Employee;
import com.youtube.repository.EmployeeRepo;
import com.youtube.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee addEmployee(Employee employee) {
       Employee emp = employeeRepo.save(employee);
        return emp;
    }

    @Override
    public String removeEmployee(int id) {
        employeeRepo.deleteById(id);
        return "delete data succesfully";
    }

    @Override
    public Optional<Employee> findEmpByID(int id) {
        Optional<Employee> emp = employeeRepo.findById(id);
        if (emp.isPresent()) {
            return emp;
        } else {


            return null;
        }
    }
    @Override
    public String updateEmployee(int id) {
        Optional<Employee> emp = employeeRepo.findById(id);
        if (emp.isPresent()) {
            Employee emps = new Employee();
            employeeRepo.save(emps);
            return "updated succesfully";

        } else {
            return "updated not succesfully";
        }

    }
        @Override
        public List<Employee> getAllEmployee () {
            List<Employee> empList = employeeRepo.findAll();
            return empList;

        }
    }
