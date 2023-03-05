package ru.spring.rest.DAO;

import ru.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Employee> getAllEmpl() {
        Session session = sessionFactory.getCurrentSession();

        List<Employee> allEmpl = session.createQuery("from Employee", Employee.class).getResultList();
        return allEmpl;
    }

    @Override
    public void saveEmpl(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmpl(int id) {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmpl(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Employee> query = session.createQuery("delete from Employee " +
                "where id =:employeeID");
        query.setParameter("employeeID", id);
        query.executeUpdate();
    }
}
