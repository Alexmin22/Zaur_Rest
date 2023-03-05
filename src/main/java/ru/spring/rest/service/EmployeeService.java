package ru.spring.rest.service;

import ru.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmpl();

    public void saveEmpl(Employee employee);

    public Employee getEmpl(int id);

    public void deleteEmpl(int id);
}
