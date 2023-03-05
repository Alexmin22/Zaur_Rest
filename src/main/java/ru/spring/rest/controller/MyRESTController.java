package ru.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spring.rest.entity.Employee;
import ru.spring.rest.exception_handing.EmplNumbNotFind;
import ru.spring.rest.exception_handing.NoSuchEmplExcep;
import ru.spring.rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmpls() {
        List<Employee> allEmp = employeeService.getAllEmpl();
        return  allEmp;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmpl(@PathVariable int id) {
        Employee employee = employeeService.getEmpl(id);

        if(employee == null) {
            throw new NoSuchEmplExcep("Работника с id "+ id + " не обнаружено в БД");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmp(@RequestBody Employee employee) {
        employeeService.saveEmpl(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmp(@RequestBody Employee employee) {
        employeeService.saveEmpl(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmp(@PathVariable int id) {

        Employee employee = employeeService.getEmpl(id);
        if (employee == null) {
            throw new NoSuchEmplExcep("Rabotnika s id = " + id +" ne obnaruzheno");
        }
        employeeService.deleteEmpl(id);
        return "Rabotnik s id "+ id + " byl udalen";
    }
}
