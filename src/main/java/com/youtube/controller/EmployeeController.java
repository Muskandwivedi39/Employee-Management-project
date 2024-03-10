package com.youtube.controller;


import com.youtube.model.Employee;
import com.youtube.repository.EmployeeRepo;
import com.youtube.serviceIMPL.EmployeeServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
   private EmployeeServiceIMPL empservice;
    @GetMapping("/home")
    public String homepage(){

        return "Welcome to Employee Management";
    }
    @PostMapping("/addEmp")
    public ResponseEntity<Employee> addEmployee(@RequestBody  Employee employee) {
        Employee emp = empservice.addEmployee(employee);

        return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
    }
        @DeleteMapping("/removeEmp")
        public ResponseEntity<String> removeEmployee(@PathVariable int id){
            empservice.removeEmployee(id);
            return new ResponseEntity<String>("remove succesfully", HttpStatus.ACCEPTED);
        }
        @GetMapping("/findEmp/{id}")
    public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id){
        Optional<Employee> emps=empservice.findEmpByID(id);
        return new ResponseEntity<Optional<Employee>>(emps, HttpStatus.ACCEPTED);
    }
    @GetMapping("/All")
    public ResponseEntity<List<Employee>> listEmployees(){
        List<Employee> LEmp= empservice.getAllEmployee();
        return new ResponseEntity<List<Employee>>(LEmp, HttpStatus.ACCEPTED);
    }

}
