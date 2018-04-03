package com.sb.dao;

import com.sb.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        criteria.setMaxResults(1)
                .add( Restrictions.like("name", "s%"))
                .addOrder( Order.desc("name") );
        return criteria.list();
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return employee;
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return (Employee) sessionFactory.getCurrentSession().get(
                Employee.class, employeeId);
    }
}
