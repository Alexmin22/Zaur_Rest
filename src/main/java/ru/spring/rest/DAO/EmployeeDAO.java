package ru.spring.rest.DAO;

import ru.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmpl();

    public void saveEmpl(Employee employee);

    public Employee getEmpl(int id);

    public void deleteEmpl(int id);
}
