package org.example.controller;

import org.example.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public ResponseEntity<Employee> sendEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        System.out.println(employee.getName() + " " + employee.getSurname());
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
