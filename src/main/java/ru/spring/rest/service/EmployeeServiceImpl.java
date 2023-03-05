package ru.spring.rest.service;

import ru.spring.rest.DAO.EmployeeDAO;
import ru.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    @Transactional
    public List<Employee> getAllEmpl() {
        return employeeDAO.getAllEmpl();

    }

    @Override
    @Transactional
    public void saveEmpl(Employee employee) {
        employeeDAO.saveEmpl(employee);
    }

    @Override
    @Transactional
    public Employee getEmpl(int id) {
        return employeeDAO.getEmpl(id);
    }

    @Override
    @Transactional
    public void deleteEmpl(int id) {
        employeeDAO.deleteEmpl(id);
    }
}
